package main.exprInterpreter.token;

public class Token {
	private TokenType type;
	private char[] value;
	
	public Token(TokenType type, char[] value) {
		this.type = type;
		this.value = value;
	}
	
	public Token(TokenType type, OperatorType operatorType) {
		this.type = type;
		this.value = new char[] {
			operatorType.getValue()
		};
	}

	public TokenType getType() {
		return type;
	}

	public void setType(TokenType type) {
		this.type = type;
	}

	public char[] getValue() {
		return value;
	}

	public void setValue(char[] value) {
		this.value = value;
	}
}
