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

	private int num_open_parentheses;
	private int num_close_parentheses;

	
	public ParserExpr(List<Token> tokens) {
		this.index = 0;
		this.tokens = tokens;
		this.root = null;
		this.num_open_parentheses = 0;
		this.num_close_parentheses = 0;
	}
	
	public NodeCalc parse() throws ParserException {
		this.root = new NodeCalc();
		this.current = this.root;
		while(peak().isPresent()) {
			if(this.index == this.tokens.length()) break;

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
				this.num_open_parentheses++;
			} else if(peak().get().getType().equals(TokenType.NUMBER)) {
				
				if(this.tokens.get(this.index + 1) != null) {
					if(this.tokens.get(this.index + 1).getValue().equals("*") || 
						this.tokens.get(this.index + 1).getValue().equals("/")) {
							int value = Integer.parseInt(consume().getValue());
							NodeTerm term = new NodeTerm();
							term.setValue(value);

							NodeCalc new_calc = new NodeCalc();
							new_calc.setLeft_expr(new NodeExpr(term));
							this.current.setRight_expr(new NodeExpr(new_calc));
							new_calc.setPrev_calc(this.current);
							this.current = (NodeCalc) this.current.getRight_expr().getExpr();
							continue;
						}
				}

				int value = Integer.parseInt(consume().getValue());
				NodeTerm term = new NodeTerm();
				term.setValue(value);

				if(this.current.getLeft_expr() == null) {
					this.current.setLeft_expr(new NodeExpr(term));
				} else {
					// Optional<Token> current = peak();
					// boolean empty = current.isEmpty();
					// if(!empty) {
					// 	if(current.get().getType().equals(TokenType.OPERATOR)) {
					// 		this.current.setRight_expr(new NodeExpr(term));
		
					// 		NodeCalc prev_calc = new NodeCalc();
					// 		prev_calc.setLeft_expr(new NodeExpr(this.current));
					// 		this.current.setPrev_calc(prev_calc);
					// 		this.root = prev_calc;
					// 		this.current = prev_calc;
					// 		continue;
					// 	}
					// }
					this.current.setRight_expr(new NodeExpr(term));
				}
			} else if(peak().get().getType().equals(TokenType.OPERATOR)) {
				if(this.current.getOperator() != ' ') {
					throw new ParserException("Invalid expression");
				}
				if(this.current.getLeft_expr() == null) {
					throw new ParserException("Invalid expression");
				}
				char operator = consume().getValue().charAt(0);

				if(this.current.getLeft_expr() != null && 
					this.current.getOperator() != ' ' && 
					this.current.getRight_expr() != null) {
						NodeCalc new_calc = new NodeCalc();
						new_calc.setLeft_expr(new NodeExpr(this.current));
						new_calc.setOperator(operator);
						this.current.setPrev_calc(new_calc);
						this.current = new_calc;
						this.root = new_calc;
						continue;
				} else {
					this.current.setOperator(operator);
				}
			} else if(peak().get().getType().equals(TokenType.CLOSE_PARENTHESES)) {
				this.index--;
				Optional<Token> current = peak();
				boolean empty = current.isEmpty();
				if(!empty) {
					if(peak().get().getType().equals(TokenType.CLOSE_PARENTHESES) || peak().get().getType().equals(TokenType.NUMBER)) {
						this.index++;
						if(this.current.getPrev_calc() != null) {
							this.current = this.current.getPrev_calc();
							consume();
						} else {
							throw new ParserException("Invalid expression");
						}
					} else {
						throw new ParserException("Invalid expression");
					}
				} else {
					throw new ParserException("Invalid expression");
				}
				this.num_close_parentheses++;
			}
		}
		if(this.num_open_parentheses != this.num_close_parentheses) {
			throw new ParserException("Invalid expression");
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
