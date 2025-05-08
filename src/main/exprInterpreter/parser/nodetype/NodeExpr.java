package main.exprInterpreter.parser.nodetype;

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

	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NodeExpr other = (NodeExpr) obj;
        return this.expr.equals(other.expr);
    }

    @Override
    public int hashCode() {
        return expr.hashCode();
    }
}
