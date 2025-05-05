package main.exprInterpreter.nodetype;

public final class NodeExpr {
	private NodeExprValue expr;

    public NodeExpr(NodeExprValue value) {
        this.setExpr(value);
    }

	public NodeExprValue getExpr() {
		return expr;
	}

	public void setExpr(NodeExprValue expr) {
		this.expr = expr;
	}
}
