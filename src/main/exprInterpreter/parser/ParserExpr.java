package main.exprInterpreter.parser;

import java.util.Optional;

import main.exprInterpreter.datastruct.*;
import main.exprInterpreter.parser.nodetype.*;
import main.exprInterpreter.token.OperatorType;
import main.exprInterpreter.token.Token;
import main.exprInterpreter.token.TokenType;

public class ParserExpr {
	private Queue<Token> tokens;
	
	public ParserExpr(Queue<Token> tokens) {
		this.tokens = tokens;
	}
	
	public NodeExpression parse() throws ParserException {
		NodeExpression expr = new NodeExpression();
		if(this.tokens.size() == 1 && this.tokens.getValue().getType().equals(TokenType.NUMBER)) {
			char[] value = this.tokens.getValue().getValue();
			expr.setLeft(
				new NodeTerm(
					new NodeFactor(value)
				)
			);
			expr.setOperation(
				new Token(
					TokenType.OPERATOR,
					OperatorType.MULTIPLICATION
				)
			);
			expr.setRight(
				new NodeTerm(
					new NodeFactor(new char[] {'1'})
				)
			);
			return expr;
		}

		expr = parseExpression();
		if(expr.getRight() == null && expr.getLeft().getType() instanceof NodeExpression) {
			return (NodeExpression) expr.getLeft().getType();
		} else if(expr.getRight() == null && expr.getLeft().getType() instanceof NodeTrig) {
			expr.setLeft(
				new NodeTerm(expr.getLeft().getType())
			);
			expr.setOperation(
				new Token(
					TokenType.OPERATOR,
					OperatorType.MULTIPLICATION
				)
			);
			expr.setRight(
				new NodeTerm(
					new NodeFactor(new char[] {'1'})
				)
			);
			return expr;
		}
		return expr;
	}

	private NodeExpression parseExpression() throws ParserException {
		NodeTerm term = parseTerm();

		if(this.tokens.isEmpty() && !(term.getType() instanceof NodeExpression)) {
			NodeExpression expr = new NodeExpression();
			expr.setLeft(term);
			return expr;
		} else if(this.tokens.isEmpty() && term.getType() instanceof NodeExpression) {
			return (NodeExpression) term.getType();
		}
		
		
		Token currentToken = peak().get();
		if(currentToken.getType().equals(TokenType.OPERATOR)) {
			NodeExpression newExpr = new NodeExpression();
			newExpr.setLeft(term);
			newExpr.setOperation(consume());
			NodeExpression expr = parseExpression();
 			if(expr.getRight() == null) {
				newExpr.setRight(expr.getLeft());
			} else {
				newExpr.setRight(new NodeTerm(expr));
			}
			return newExpr;
		} else if(currentToken.getType().equals(TokenType.CLOSE_PARENTHESES)){
			NodeExpression expr = new NodeExpression();
			expr.setLeft(term);
			return expr;
	 	} else {
			throw new ParserException(
				"Invalid expression: missing <TokenType.OPERATOR>"
			);
		}
		
	}

	private NodeTerm parseTerm() throws ParserException {
		NodeTerm nodeTerm = parseTermPower();

		if(this.tokens.isEmpty()) {
			return nodeTerm;
		}
		
		Token currentToken = peak().get();

		if(currentToken.getType().equals(TokenType.OPERATOR)) {
			if(currentToken.getValue()[0] == OperatorType.MULTIPLICATION.getValue() ||
				currentToken.getValue()[0] == OperatorType.DIVISION.getValue()) {
				NodeExpression newExpr = new NodeExpression();
				newExpr.setLeft(nodeTerm);
				newExpr.setOperation(consume());
				newExpr.setRight(parseTerm());
				return new NodeTerm(newExpr);
			} else {
				return nodeTerm;
			}
		} else if(currentToken.getType().equals(TokenType.CLOSE_PARENTHESES)){
			return nodeTerm;
	 	} else {
			throw new ParserException(
				"Invalid expression: missing <TokenType.OPERATOR>"
			);
		}		
	}

	private NodeTerm parseTermPower() throws ParserException {
		NodeTermType nodeTermType = parseFactor();

		if(this.tokens.isEmpty()) {
			return new NodeTerm(nodeTermType);
		}
		
		Token currentToken = peak().get();

		if(currentToken.getType().equals(TokenType.OPERATOR)) {
			if(
				currentToken.getValue()[0] == OperatorType.EXPONENTIATION.getValue()
			){
				NodeExpression newExpr = new NodeExpression();
				newExpr.setLeft(new NodeTerm(nodeTermType));
				newExpr.setOperation(consume());
				newExpr.setRight(parseTermPower());
				return new NodeTerm(newExpr);
			} else {
				return new NodeTerm(nodeTermType);
			}
		} else if(currentToken.getType().equals(TokenType.CLOSE_PARENTHESES)){
			return new NodeTerm(nodeTermType);
	 	} else {
			throw new ParserException(
				"Invalid expression: missing <TokenType.OPERATOR>"
			);
		}		
	}

	private NodeTermType parseFactor() throws ParserException {

		Token currentToken = peak().get();

		if(currentToken.getType().equals(TokenType.NUMBER) ||
			currentToken.getType().equals(TokenType.VARIABLE_X)
		) {
			return new NodeFactor(consume().getValue());
		} else if(currentToken.getType().equals(TokenType.OPEN_PARENTHESES)) {
			consume();
			NodeExpression expr = this.parseExpression();
			try {
				currentToken = peak().get();
			} catch (Exception err) {
				throw new ParserException(
					"Invalid expression: missing <TokenType.CLOSE_PARENTHESES>"
				);
			}
			
			if(!currentToken.getType().equals(TokenType.CLOSE_PARENTHESES) || !peak().isPresent()) {
				throw new ParserException(
					"Invalid expression: missing <TokenType.CLOSE_PARENTHESES>"
				);
			}

			consume();

			if(expr.getRight() == null) {
				return expr.getLeft().getType();
			}

			return expr;
		} else if(currentToken.getType().equals(TokenType.TRIG)) {
			NodeTrig trigExpr = new NodeTrig();
			trigExpr.setFuncTring(currentToken.getValue());
			consume();
			consume();
			NodeExpression expr = parseExpression();
			if(expr.getRight() == null) {
				trigExpr.setType(new NodeTerm(
					expr.getLeft().getType()
				));
			} else {
				trigExpr.setType(new NodeTerm(expr));
			}
			consume();
			return trigExpr;
		} else {
			throw new ParserException(
				"Invalid expression: missing <TokenType.NUMBER> or <TokenType.OPEN_PARENTHESES>"
			);
		}
	}
	
	private Optional<Token> peak() {
		if(this.tokens.isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.ofNullable(this.tokens.getValue());
		}
	}
	
	private Token consume() {
		return this.tokens.pop();
	}
}
