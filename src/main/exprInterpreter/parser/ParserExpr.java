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
	private NodeExpression root;
	private NodeExpression current;
	
	public ParserExpr(List<Token> tokens) {
		this.index = 0;
		this.tokens = tokens;
		this.root = null;
	}
	
	public NodeExpression parse() throws ParserException {
		return parseExpression();
	}

	private NodeExpression parseExpression() throws ParserException {
		NodeTerm term = parseTerm();
		
		if(peak().isEmpty()) {
			NodeExpression expr = new NodeExpression();
			expr.setLeft(term);
			return expr;
		} else if(term == null) {
			return null;
		}
		
		Token currentToken = peak().get();
		if(currentToken.getType().equals(TokenType.OPERATOR)) {
			NodeExpression newExpr = new NodeExpression();
			newExpr.setLeft(term);
			newExpr.setOperation(consume());
			NodeExpression expr = parseExpression();
			if(expr.getRight() != null) {
				newExpr.setRight(new NodeTerm(expr));
			} else {
				newExpr.setRight(expr.getLeft());
			}
			
			return newExpr;
		} else {
			throw new ParserException(
				"Invalid expression: missing <TokenType.NUMBER> or <TokenType.OPEN_PARENTHESES>"
			);
		}
		
	}

	private NodeTerm parseTerm() throws ParserException {
		NodeTermType nodeTermType = parseFactor();
		
		if(peak().isEmpty()) {
			return new NodeTerm(nodeTermType);
		} else if(nodeTermType == null) {
			return null;
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
				NodeExpression expr = parseExpression();
				if(expr.getRight() != null) {
					newExpr.setRight(new NodeTerm(expr));
				} else {
					newExpr.setRight(expr.getLeft());
				}
				newExpr.setRight(new NodeTerm(expr));
				return new NodeTerm(newExpr);
			} else {
				return new NodeTerm(nodeTermType);
			}
		} else {
			throw new ParserException(
				"Invalid expression: missing <TokenType.NUMBER> or <TokenType.OPEN_PARENTHESES>"
			);
		}		
	}

	private NodeTermType parseFactor() throws ParserException {
		
		if(peak().isEmpty()) {
			return null;
		}
		
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
		}

		throw new ParserException(
			"Invalid expression: migging <TokenType.NUMBER> or <TokenType.OPEN_PARENTHESES>"
		);
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
