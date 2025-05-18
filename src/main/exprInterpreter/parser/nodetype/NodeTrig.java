package main.exprInterpreter.parser.nodetype;

public final class NodeTrig implements NodeTermType {
    private NodeTrigType type;

    public NodeTrig(NodeTrigType type) {
        this.setType(type);
    }

    public NodeTrig() { }

    public NodeTrigType getType() {
        return type;
    }

    public void setType(NodeTrigType type) {
        this.type = type;
    }
}
