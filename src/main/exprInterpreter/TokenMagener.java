package main.exprInterpreter;

import main.exprInterpreter.datastruct.linkedlist.*;



public class TokenMagener {
	public static List<Token> tokenize(String expr) {
		List<Token> tokens = new List<Token>();
		
		for(int i = 0; i < expr.length(); i++) {
			char current_character = expr.charAt(i);
			String buff = "";
			if(Character.isWhitespace(current_character)) continue;
			
			if(current_character == '+') { // if current_character == +
				buff += current_character;
			} else if(current_character == '-') { // if current_character == -
				buff += current_character;			
			} else if(current_character == '*') { // if current_character == *
				buff += current_character;
			} else if(current_character == '/') { // if current_character == /
				buff += current_character;
			} else if(current_character == '(') { // if current_character == (
				buff += current_character;
			} else if(current_character == ')') { // if current_character == )
				buff += current_character;
			} else if(current_character == 'x' || current_character == 'X') {
				buff += current_character;
			} else if(current_character == '^') {
				buff += current_character;
			} else if(Character.isDigit(current_character)) {
				try {
					while(Character.isDigit(expr.charAt(i))) {
						buff += expr.charAt(i);
						i++;
					}
				} catch (Exception e) { }
				i--;
			}
			
			
			if(isNumeric(buff)) {
				tokens.add(new Token(TokenType.NUMBER, buff.toCharArray()));
			} else if(buff.equals(Character.toString(TokenType.ADDITION.getValue()))) {
				tokens.add(new Token(TokenType.ADDITION, buff.toCharArray()));
			} else if(buff.equals(Character.toString(TokenType.SUBTRACTION.getValue()))) {
				tokens.add(new Token(TokenType.SUBTRACTION, buff.toCharArray()));
			} else if(buff.equals(Character.toString(TokenType.MULTIPLICATION.getValue()))) {
				tokens.add(new Token(TokenType.MULTIPLICATION, buff.toCharArray()));
			} else if(buff.equals(Character.toString(TokenType.DIVISION.getValue()))) {
				tokens.add(new Token(TokenType.DIVISION, buff.toCharArray()));
			} else if(buff.equals(Character.toString(TokenType.OPEN_PARENTHESES.getValue()))) {
				tokens.add(new Token(TokenType.OPEN_PARENTHESES, buff.toCharArray()));
			} else if(buff.equals(Character.toString(TokenType.CLOSE_PARENTHESES.getValue()))) {
				tokens.add(new Token(TokenType.CLOSE_PARENTHESES, buff.toCharArray()));
			} else if(buff.equals(Character.toString(TokenType.EXPONENTIATION.getValue()))) {
				tokens.add(new Token(TokenType.EXPONENTIATION, buff.toCharArray()));
			} else if(buff.equals(Character.toString(TokenType.VARIABLE_X.getValue()))) {
				tokens.add(new Token(TokenType.VARIABLE_X, buff.toCharArray()));
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
}
