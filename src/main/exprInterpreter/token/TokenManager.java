package main.exprInterpreter.token;

import java.util.Optional;

import main.exprInterpreter.datastruct.*;

public class TokenManager {
	
	private int index;
	private String expr;
	
	public TokenManager(String expr) {
		this.index = 0;
		this.expr = expr;
	}
	
	public Queue<Token> tokenize() throws TokenException {
		Queue<Token> tokens = new Queue<Token>();
		
		while(this.peak().isPresent()) {
			String buff = "";
			char current_character = this.consume();
			if(Character.isWhitespace(current_character)) continue;
			
			switch (current_character) {
				case '+':
				case '-':
				case '*':
				case '/':
				case '(':
				case ')':
				case 'x':
				case '^':
					if(current_character == '-') {
						char character = this.consume();
						if(Character.isDigit(character)) {
							try {
								while(Character.isDigit(character)) {
									buff += character;
									character = this.consume();
								}
							} catch (Exception err) { }
							
							if(character != ' ') {
								this.index--;
							}
							buff = current_character + "" + character;
							break;
						} else if(character == 'x') {
							buff = current_character + "" + character;
							break;
						}
						
					}
					buff += current_character;
					break;
	
				default:
					if (Character.isDigit(current_character)) {
						try {
							while (Character.isDigit(current_character)) {
								buff += current_character;
								current_character = this.consume();
							}
						} catch (Exception e) { }
					} else {
						try {
							while (Character.isLetter(current_character)) {
								buff += current_character;
								current_character = this.consume();
							}
						} catch (Exception e) { }
					}
					if(current_character != ' ') {
						this.index--;
					}
					break;
			}
			
			if (isNumeric(buff)) {
				tokens.add(new Token(
					TokenType.NUMBER,
					buff.toCharArray()
				));
			} else if (buff.length() == 1) {
				char symbol = buff.charAt(0);
				switch (symbol) {
					case '+':
						tokens.add(new Token(TokenType.OPERATOR, OperatorType.ADDITION));
						break;
					case '-':
						tokens.add(new Token(TokenType.OPERATOR, OperatorType.SUBTRACTION));
						break;
					case '*':
						tokens.add(new Token(TokenType.OPERATOR, OperatorType.MULTIPLICATION));
						break;
					case '/':
						tokens.add(new Token(TokenType.OPERATOR, OperatorType.DIVISION));
						break;
					case '(':
						tokens.add(new Token(
							TokenType.OPEN_PARENTHESES,
							new char[] {'('}
						));
						break;
					case ')':
						tokens.add(new Token(
							TokenType.CLOSE_PARENTHESES,
							new char[] {')'}
						));
						break;
					case '^':
						tokens.add(new Token(TokenType.OPERATOR, OperatorType.EXPONENTIATION));
						break;
					case 'x':
						tokens.add(new Token(
							TokenType.VARIABLE_X,
							new char[] {'x'}
						));
						break;
					default:
						throw new TokenException("Invalid symbol: " + buff);
				}
			} else if(buff.equals("sin")) {
				tokens.add(new Token(
					TokenType.TRIG,
					TrigType.SIN
				));
			} else if(buff.equals("cos")) {
				tokens.add(new Token(
					TokenType.TRIG,
					TrigType.COS
				));
			} else if(buff.equals("tan")) {
				tokens.add(new Token(
					TokenType.TRIG,
					TrigType.TAN
				));
			} else if(buff.equals("-x")) {
				tokens.add(new Token(
						TokenType.VARIABLE_X,
						new char[] {'-', 'x'}
					));
			} else if(buff.equals("log")) {
				tokens.add(new Token(
					TokenType.LOGARITHM,
					LogarithmType.LOG
				));
			} else if(buff.equals("ln")) {
				tokens.add(new Token(
					TokenType.LOGARITHM,
					LogarithmType.LN
				));
			} else {
				throw new TokenException("Invalid token: " + buff);
			}
		}
		return tokens;
	}
	
	private static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	private Optional<Character> peak() {
		if(this.index > this.expr.length()) {
			return Optional.empty();
		} else {
			try {
				return Optional.ofNullable(this.expr.charAt(this.index));
			} catch (Exception err) {
				return Optional.empty();
			}
			
		}
	}
	
	private char consume() {
		return this.expr.charAt(this.index++);
	}
}
