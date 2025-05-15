package main.exprInterpreter.parser;

import java.util.Optional;

import main.exprInterpreter.datastruct.linkedlist.*;
import main.exprInterpreter.parser.nodetype.*;
import main.exprInterpreter.token.OperatorType;
import main.exprInterpreter.token.Token;
import main.exprInterpreter.token.TokenType;

public class ParserExpr {
    private int index;
	private List<Token> tokens;
	
	public ParserExpr(List<Token> tokens) {
		this.index = 0;
		this.tokens = tokens;
	}
	
	public NodeExpression parse() throws ParserException {
		return parseExpression();
	}

	private NodeExpression parseExpression() throws ParserException {
		NodeTerm term = parseTerm();

		if(this.index >= tokens.length()) {
			NodeExpression expr = new NodeExpression();
			expr.setLeft(term);
			return expr;
		}
		
		
		Token currentToken = peak().get();
		if(currentToken.getType().equals(TokenType.OPERATOR)) {
			NodeExpression newExpr = new NodeExpression();
			newExpr.setLeft(term);
			newExpr.setOperation(consume());
			NodeTerm newTerm = parseTerm();
 			newExpr.setRight(newTerm);
			return newExpr;
		} else {
			throw new ParserException(
				"Invalid expression: missing <TokenType.NUMBER> or <TokenType.OPEN_PARENTHESES>"
			);
		}
		
	}

	private NodeTerm parseTerm() throws ParserException {
		NodeTermType nodeTermType = parseFactor();

		if(this.index >= tokens.length()) {
			return new NodeTerm(nodeTermType);
		}
		
		Token currentToken = peak().get();

		if(currentToken.getType().equals(TokenType.OPERATOR)) {
			if(currentToken.getValue().equals(
					Character.toString(OperatorType.MULTIPLICATION.getValue())) ||
				currentToken.getValue().equals(
					Character.toString(OperatorType.DIVISION.getValue())
			)) {
				NodeExpression newExpr = new NodeExpression();
				newExpr.setLeft(new NodeTerm(nodeTermType));
				newExpr.setOperation(consume());
				NodeTerm newTerm = parseTerm();
				newExpr.setRight(newTerm);
				return new NodeTerm(newExpr);
			} else {
				return new NodeTerm(nodeTermType);
			}
		} else if(currentToken.getType().equals(TokenType.CLOSE_PARENTHESES)) {
			consume();
			return null;
		} else {
			throw new ParserException(
				"Invalid expression: missing <TokenType.NUMBER> or <TokenType.OPEN_PARENTHESES>"
			);
		}		
	}

	private NodeTermType parseFactor() throws ParserException {

		Token currentToken = peak().get();

		if(currentToken.getType().equals(TokenType.NUMBER)) {
			int value = Integer.parseInt(consume().getValue());
			return new NodeFactor(value);
		} else if(currentToken.getType().equals(TokenType.OPEN_PARENTHESES)) {
			consume();
			NodeExpression expr = this.parseExpression();
			if(!currentToken.getType().equals(TokenType.CLOSE_PARENTHESES) || !peak().isPresent()) {
				throw new ParserException(
					"Invalid expression: missing <TokenType.CLOSE_PARENTHESES>"
				);
			}
			consume();
			return expr;
		} else {
			throw new ParserException(
				"Invalid expression: migging <TokenType.NUMBER> or <TokenType.OPEN_PARENTHESES>"
			);
		}

		
	}
	
	private Optional<Token> peak() {
		if(this.index > this.tokens.length()) {
			return Optional.empty();
		} else {
			return Optional.ofNullable(this.tokens.get(this.index));
		}
	}
	
	private Token consume() {
		return this.tokens.get(this.index++);
	}
}
