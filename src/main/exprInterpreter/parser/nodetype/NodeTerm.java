package main.exprInterpreter.parser.nodetype;

public final class NodeTerm {
    private NodeTermType value;

    public NodeTerm() { }

    public NodeTermType getValue() {
        return value;
    }

    public void setValue(NodeTermType value) {
        this.value = value;
    }
}
