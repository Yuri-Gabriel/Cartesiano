package main.exprInterpreter.parser.nodetype;

public final class NodeLog implements NodeTermType {
    private NodeTerm type;
    private char[] funcLog;

    public NodeLog(NodeTerm type, char[] funcLog) {
        this.setType(type);
        this.setFuncLog(funcLog);
    }

    public NodeLog() {  }

    public NodeTerm getType() {
        return type;
    }
    public void setType(NodeTerm type) {
        this.type = type;
    }
    public char[] getFuncLog() {
        return funcLog;
    }
    public void setFuncLog(char[] funcLog) {
        this.funcLog = funcLog;
    }
}
