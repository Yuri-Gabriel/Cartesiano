package main.exprInterpreter.parser;

import java.util.Optional;
import main.exprInterpreter.datastruct.linkedlist.*;
import main.exprInterpreter.parser.nodetype.*;
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

	public NodeExpression parseExpression() throws ParserException {
		
	}

	public NodeTerm parseTerm() throws ParserException {
		
	}

	public NodeTermType parseFactor() throws ParserException {
		Token token = peak().orElseThrow(() ->  new ParserException(""));

		if(token.getType().equals(TokenType.NUMBER)) {
			int value = Integer.parseInt(consume().getValue());
			return new NodeFactor(value);
		} else if(token.getType().equals(TokenType.OPEN_PARENTHESES)) {
			consume();
			NodeExpression expr =  this.parseExpression();
			if(!token.getType().equals(TokenType.CLOSE_PARENTHESES) || !peak().isPresent()) {
				throw new ParserException(null);
			}
			consume();
			return expr;
		}

		throw new ParserException("Invalid expression");
	}
	
	public NodeCalc parse() {
		return null;
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
