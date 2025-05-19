package main.exprInterpreter.parser.nodetype;

public final class NodeTrig implements NodeTermType {
    private NodeTerm type;
    private char[] funcTring;

    public NodeTrig(NodeTerm type, char[] funcTring) {
        this.setType(type);
        this.setFuncTring(funcTring);
    }

    public NodeTrig() { }

    public NodeTerm getType() {
        return type;
    }

    public void setType(NodeTerm type) {
        this.type = type;
    }

    public char[] getFuncTring() {
        return funcTring;
    }
    public void setFuncTring(char[] funcTring) {
        this.funcTring = funcTring;
    }
}
