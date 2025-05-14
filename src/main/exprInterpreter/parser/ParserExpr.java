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
		this.root = null;git 
	}

	public NodeExpression parseExpression() throws ParserException {
		NodeTerm term = parseTerm();
		Token currentToken = peak().get();

		if(currentToken != null) {
			if(currentToken.getType().equals(TokenType.OPERATOR)) {
				NodeExpression newExpr = new NodeExpression();
				newExpr.setLeft(term);
				newExpr.setOperation(consume());
				newExpr.setRight(parseTerm());
				return newExpr;
			} else {
				throw new ParserException(
					"Invalid expression: missing <TokenType.NUMBER> or <TokenType.OPEN_PARENTHESES>"
				);
			}
		} else {
			return (NodeExpression) term.getType();
		}
		
	}

	public NodeTerm parseTerm() throws ParserException {
		NodeTermType nodeTermType = parseFactor();
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
				newExpr.setRight(parseTerm());
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

	public NodeTermType parseFactor() throws ParserException {
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
