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
	
	public NodeCalc parse() throws ParserException {
		this.root = new NodeCalc();
		this.current = this.root;
		while(peak().isPresent()) {
			if(peak().get().getType().equals(TokenType.OPEN_PARENTHESES)) {
				NodeCalc next_calc = new NodeCalc();
				if(this.current == this.root && this.root.getLeft_expr() == null) {
					next_calc.setPrev_calc(this.current);
					this.current.setLeft_expr(new NodeExpr(next_calc));
					this.current = (NodeCalc) this.current.getLeft_expr().getExpr();
				} else {
					next_calc.setPrev_calc(this.current);
					this.current.setRight_expr(new NodeExpr(next_calc));
					this.current = (NodeCalc) this.current.getRight_expr().getExpr();
				}
				consume();
			} else if(peak().get().getType().equals(TokenType.NUMBER)) {
				int value = Integer.parseInt(consume().getValue());
				NodeTerm term = new NodeTerm();
				term.setValue(value);

				if(this.current.getLeft_expr() == null) {
					this.current.setLeft_expr(new NodeExpr(term));
				} else {
					if(peak().get().getType().equals(TokenType.OPERATOR)) {
						this.current.setRight_expr(new NodeExpr(term));
	
						NodeCalc prev_calc = new NodeCalc();
						prev_calc.setLeft_expr(new NodeExpr(this.current));
						this.current.setPrev_calc(prev_calc);
						this.root = prev_calc;
						this.current = prev_calc;
						continue;
					}

					this.current.setRight_expr(new NodeExpr(term));
				}

				

				
				
			} else if(peak().get().getType().equals(TokenType.OPERATOR)) {
				if(this.current.getLeft_expr() == null) {
					throw new ParserException("Invalid expression");
				}
				char operator = consume().getValue().charAt(0);
				this.current.setOperator(operator);
			} else if(peak().get().getType().equals(TokenType.CLOSE_PARENTHESES)) {
				this.current = this.current.getPrev_calc();
				consume();
			}
		}	
		return this.root;
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
