package main.exprInterpreter.parser.nodetype;

public class NodeTerm {
    private NodeTermType type;

    public NodeTerm(NodeTermType type) {
        this.setType(type);
    }

    public NodeTermType getType() {
        return type;
    }

    public void setType(NodeTermType type) {
        this.type = type;
    }
}
