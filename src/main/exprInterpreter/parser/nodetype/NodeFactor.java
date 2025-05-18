package main.exprInterpreter.parser.nodetype;

public final class NodeFactor implements NodeTermType, NodeTrigType {
    private char[] value;

    public NodeFactor(char[] value) {
        this.setValue(value);
    }

    public char[] getValue() {
        return value;
    }

    public void setValue(char[] value) {
        this.value = value;
    }

    
}
