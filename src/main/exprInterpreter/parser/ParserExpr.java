package main.exprInterpreter.parser;

import java.util.Optional;
import main.exprInterpreter.datastruct.linkedlist.*;
import main.exprInterpreter.parser.nodetype.*;
import main.exprInterpreter.token.Token;
import main.exprInterpreter.token.TokenType;

public class ParserExpr {
    private int index;
	private List<Token> tokens;
	private NodeCalc root;
	private NodeCalc current;
	
	public ParserExpr(List<Token> tokens) {
		this.index = 0;
		this.tokens = tokens;
		this.root = null;
	}

	public NodeExpression parseExpression() {
		return null;
	}

	public NodeFactor parseFactor() {
		return null;
	}

	public NodeTerm parseTerm() {
		return null;
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
