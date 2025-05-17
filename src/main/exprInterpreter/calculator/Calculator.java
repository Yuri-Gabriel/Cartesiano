package main.exprInterpreter.calculator;

import main.exprInterpreter.datastruct.Queue;

import main.exprInterpreter.parser.ParserException;
import main.exprInterpreter.parser.ParserExpr;
import main.exprInterpreter.parser.nodetype.NodeExpression;
import main.exprInterpreter.parser.nodetype.NodeFactor;
import main.exprInterpreter.parser.nodetype.NodeTermType;
import main.exprInterpreter.token.Token;
import main.exprInterpreter.token.TokenException;
import main.exprInterpreter.token.TokenManager;

public class Calculator {
    private Integer x_value;
    private String expression;
    private NodeExpression tree;

    public Calculator(String expression) {
        this.x_value = null;
        this.expression = expression;
        this.tree = null;
    }

    public Calculator(NodeExpression tree) {
        this.x_value = null;
        this.expression = null;
        this.tree = tree;
    }

    public double calculate() throws TokenException, ParserException, CalculatorException {

        String resultValue = "";

        if(this.expression != null) {
            if(this.expression.contains("x") && this.x_value == null) {
                throw new CalculatorException("x value is not defined");
            }

            Queue<Token> tokens = this.getQueueTokens();
            NodeExpression tree = this.getTreeExpression(tokens);

            NodeFactor result = resolveTree(tree);
            resultValue = toString(result.getValue());
        } else {
            NodeFactor result = resolveTree(this.tree);
            resultValue = toString(result.getValue());
        }

        return Double.parseDouble(resultValue);
    }

    private Queue<Token> getQueueTokens() throws TokenException {
        return new TokenManager(this.expression).tokenize();
    }

    private NodeExpression getTreeExpression(Queue<Token> tokens) throws ParserException {
        return new ParserExpr(tokens).parse();
    }

    private NodeFactor resolveTree(NodeTermType current) throws CalculatorException {
        if(current instanceof NodeExpression) {
            NodeTermType leftTermType = null;
            NodeTermType rightTermType = null;

            NodeExpression expr = (NodeExpression) current;
            leftTermType = resolveTree(expr.getLeft().getType());
            rightTermType = resolveTree(expr.getRight().getType());

            NodeFactor leftFactor = (NodeFactor) leftTermType;
            NodeFactor rightFactor = (NodeFactor) rightTermType;

            String leftValue = toString(leftFactor.getValue());
            char operator = expr.getOperation().getValue()[0];
            String rightValue = toString(rightFactor.getValue());

            if(leftValue.equals("x")) {
                leftValue = this.x_value.toString();
            }
            if(rightValue.equals("x")) {
                rightValue = this.x_value.toString();
            }

            double leftNumber = Double.parseDouble(leftValue);
            double rightNumber = Double.parseDouble(rightValue);

            double result = 0.0;

            switch (operator) {
                case '+':
                    result = leftNumber + rightNumber;
					break;
				case '-':
                    result = leftNumber - rightNumber;
					break;
				case '*':
                    result = leftNumber * rightNumber;
					break;
				case '/':
                    if(rightNumber == 0) {
                        throw new CalculatorException("Division by zero");
                    }
                    result = leftNumber / rightNumber;
					break;
				case '^':
                    if(rightNumber == 0) {
                        result = 1;
                        break;
                    }
                    result = pow(leftNumber, rightNumber);
					break;
            }
            char[] resultFactorValue = Double.toString(result).toCharArray();
            return new NodeFactor(resultFactorValue);
        }

        return (NodeFactor) current;
    }

    private String toString(char[] value) {
		String text = "";
		for(char c : value) {
			text += c;
		}
		return text;
	}

    private double pow(double a, double b) {
        return b > 0 ? a * pow(a, b - 1) : 1;
    }

    public void setX_Value(int value) {
        this.x_value = value;
    }
}
