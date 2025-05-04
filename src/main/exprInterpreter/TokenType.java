package main.exprInterpreter;

public enum TokenType {
	ADDITION('+'),
	SUBTRACTION('-'),
	DIVISION('/'),
	MULTIPLICATION('*'),
	OPEN_PARENTHESES('('),
	CLOSE_PARENTHESES(')');
	
	private char value;

	TokenType(char value) {
		this.value = value;
	}
	
	public char getValue() {
		return this.value;
	}
}
