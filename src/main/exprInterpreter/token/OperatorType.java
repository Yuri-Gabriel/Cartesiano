package main.exprInterpreter.token;

public enum OperatorType {
    ADDITION('+'),
	SUBTRACTION('-'),
	DIVISION('/'),
	MULTIPLICATION('*'),
	EXPONENTIATION('^');

    private char value;

	OperatorType(char value) {
		this.value = value;
	}
	
	OperatorType() { }
	
	public char getValue() {
		return this.value;
	}
}
