package main.exprInterpreter.parser.nodetype;

public final class NodeFactor implements NodeTermType {
    private Integer value;

    public NodeFactor() {}

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    
}
