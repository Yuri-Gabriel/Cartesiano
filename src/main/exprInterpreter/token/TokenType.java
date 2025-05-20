package main.exprInterpreter.token;

public enum TokenType {
	OPEN_PARENTHESES('('),
	CLOSE_PARENTHESES(')'),
	VARIABLE_X('x'),
	OPERATOR(),
	NUMBER(),
	TRIG(),
	LOGARITHM();
	
	private int value;

	TokenType(int value) {
		this.value = value;
	}
	
	TokenType() { }
	
	public int getValue() {
		return this.value;
	}
}
