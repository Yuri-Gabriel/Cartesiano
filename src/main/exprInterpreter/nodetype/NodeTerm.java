package main.exprInterpreter.nodetype;

public final class NodeTerm implements NodeExprValue {
	private int value;

	public NodeTerm() {}

	public NodeTerm(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NodeTerm other = (NodeTerm) obj;
        return this.value == other.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
} 
