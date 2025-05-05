package main.exprInterpreter.nodetype;

public final class NodeTerm implements NodeExprValue {
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
} 
