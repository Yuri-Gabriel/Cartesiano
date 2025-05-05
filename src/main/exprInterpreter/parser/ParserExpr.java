package main.exprInterpreter.parser;

import java.util.Optional;
import main.exprInterpreter.datastruct.linkedlist.*;
import main.exprInterpreter.nodetype.*;
import main.exprInterpreter.token.Token;

public class ParserExpr {
    private int index;
	private List<Token> tokens;
	
	public ParserExpr(List<Token> tokens) {
		this.index = 0;
		this.tokens = tokens;
	}
	
	public void parse() {
		new NodeCalc(
			new NodeExpr(
				new NodeTerm()
			),
			 '-',
			new NodeExpr(
				new NodeCalc(null, '+', null)
			)
		);
	}
	
	private Optional<Token> peak() {
		if(this.index > this.tokens.length()) {
			return Optional.empty();
		} else {
			return Optional.ofNullable(this.tokens.get(this.index));
		}
	}
	
	private String consume() {
		return this.tokens.get(this.index++).getValue();
	}
}
