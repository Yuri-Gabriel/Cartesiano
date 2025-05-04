package main.exprInterpreter;

public enum TokenType {
	ADDITION('+'),
	SUBTRACTION('-'),
	DIVISION('/'),
	MULTIPLICATION('*'),
	OPEN_PARENTHESES('('),
	CLOSE_PARENTHESES(')'),
	VARIABLE_X('x'),
	EXPONENTIATION('^'),
	NUMBER();
	
	private int value;

	TokenType(int value) {
		this.value = value;
	}
	
	TokenType() { }
	
	public int getValue() {
		return this.value;
	}
}
