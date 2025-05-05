package main.exprInterpreter.nodetype;

public final class NodeCalc implements NodeExprValue {
	private NodeExpr first_expr;
	private char operator;
	private NodeExpr second_expr;

	public NodeCalc(NodeExpr first_expr, char operator, NodeExpr second_expr) {
		this.first_expr = first_expr;
		this.operator = operator;
		this.second_expr = second_expr;
	}

	public NodeExpr getFirst_expr() {
		return first_expr;
	}
	public void setFirst_expr(NodeExpr first_expr) {
		this.first_expr = first_expr;
	}
	public char getOperator() {
		return operator;
	}
	public void setOperator(char operator) {
		this.operator = operator;
	}
	public NodeExpr getSecond_expr() {
		return second_expr;
	}
	public void setSecond_expr(NodeExpr second_expr) {
		this.second_expr = second_expr;
	}
}
