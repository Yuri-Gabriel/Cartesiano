package main.exprInterpreter;

import java.util.Optional;

import main.exprInterpreter.datastruct.linkedlist.*;



public class TokenManeger {
	
	private int index;
	private String expr;
	
	public TokenManeger(String expr) {
		this.index = 0;
		this.expr = expr;
	}
	
	public List<Token> tokenize() throws TokenException {
		List<Token> tokens = new List<Token>();
		
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
					break;
			}
			
			if (isNumeric(buff)) {
				tokens.add(new Token(TokenType.NUMBER, buff));
			} else if (buff.length() == 1) {
				char symbol = buff.charAt(0);
				switch (symbol) {
					case '+':
						tokens.add(new Token(TokenType.ADDITION));
						break;
					case '-':
						tokens.add(new Token(TokenType.SUBTRACTION));
						break;
					case '*':
						tokens.add(new Token(TokenType.MULTIPLICATION));
						break;
					case '/':
						tokens.add(new Token(TokenType.DIVISION));
						break;
					case '(':
						tokens.add(new Token(TokenType.OPEN_PARENTHESES));
						break;
					case ')':
						tokens.add(new Token(TokenType.CLOSE_PARENTHESES));
						break;
					case '^':
						tokens.add(new Token(TokenType.EXPONENTIATION));
						break;
					case 'x':
						tokens.add(new Token(TokenType.VARIABLE_X));
						break;
					default:
						throw new TokenException("Invalid symbol: " + buff);
				}
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
			return Optional.ofNullable(this.expr.charAt(this.index));
		}
	}
	
	private char consume() {
		return this.expr.charAt(this.index++);
	}
}

/*
for(int i = 0; i < expr.length(); i++) {
	char current_character = expr.charAt(i);
	String buff = "";
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
			buff += current_character;
			break;

		default:
			if (Character.isDigit(current_character)) {
				try {
					while (Character.isDigit(expr.charAt(i))) {
						buff += expr.charAt(i);
						i++;
					}
				} catch (Exception e) { }
				i--;
			} else {
				try {
					while (Character.isLetter(expr.charAt(i))) {
						buff += expr.charAt(i);
						i++;
					}
				} catch (Exception e) { }
				i--;
			}
			break;
	}
	
	
	if (isNumeric(buff)) {
		tokens.add(new Token(TokenType.NUMBER, buff));
	} else if (buff.length() == 1) {
		char symbol = buff.charAt(0);
		switch (symbol) {
			case '+':
				tokens.add(new Token(TokenType.ADDITION));
				break;
			case '-':
				tokens.add(new Token(TokenType.SUBTRACTION));
				break;
			case '*':
				tokens.add(new Token(TokenType.MULTIPLICATION));
				break;
			case '/':
				tokens.add(new Token(TokenType.DIVISION));
				break;
			case '(':
				tokens.add(new Token(TokenType.OPEN_PARENTHESES));
				break;
			case ')':
				tokens.add(new Token(TokenType.CLOSE_PARENTHESES));
				break;
			case '^':
				tokens.add(new Token(TokenType.EXPONENTIATION));
				break;
			case 'x':
				tokens.add(new Token(TokenType.VARIABLE_X));
				break;
			default:
				throw new TokenException("Invalid symbol: " + buff);
		}
	} else {
		throw new TokenException("Invalid token: " + buff);
	}
	
}
*/
