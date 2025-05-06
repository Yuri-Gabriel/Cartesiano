package main.exprInterpreter.parser;

import java.util.Optional;
import main.exprInterpreter.datastruct.linkedlist.*;
import main.exprInterpreter.nodetype.*;
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
	
	public void parse() throws ParserException {
		while(peak().isPresent()) {
			if(peak().get().getType().equals(TokenType.OPEN_PARENTHESES)) {
				if(this.root == null) {
					this.root = new NodeCalc();
					this.current = this.root;
					this.current.setLeft_expr(new NodeExpr(new NodeCalc()));
					this.current = (NodeCalc) this.current.getLeft_expr().getExpr();
				} else {
					this.current.setRight_expr(new NodeExpr(new NodeCalc()));
					this.current = (NodeCalc) this.current.getRight_expr().getExpr();
				}
			} else if(peak().get().getType().equals(TokenType.NUMBER)) {
				int value = Integer.parseInt(consume().getValue());
				NodeTerm term = new NodeTerm();
				term.setValue(value);
				if(this.current.getLeft_expr() == null) {
					this.current.setLeft_expr(new NodeExpr(term));
				} else {
					this.current.setRight_expr(new NodeExpr(term));
				}
				
			} else if(peak().get().getType().equals(TokenType.OPERATOR)) {
				if(this.current.getLeft_expr() == null) {
					throw new ParserException("Invalid expression");
				}
				char operator = consume().getValue().charAt(0);
				this.current.setOperator(operator);
			} else if(peak().get().getType().equals(TokenType.CLOSE_PARENTHESES)) {
				
			}
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
