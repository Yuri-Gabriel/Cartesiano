package main.exprInterpreter.nodetype;

public final class NodeCalc implements NodeExprValue {
	private NodeExpr left_expr;
	private char operator;
	private NodeExpr right_expr;

	public NodeCalc(NodeExpr left_expr, char operator, NodeExpr right_expr) {
		this.left_expr = left_expr;
		this.operator = operator;
		this.right_expr = right_expr;
	}
	public NodeCalc() {
		this.left_expr = null;
		this.operator = ' ';
		this.right_expr = null;
	}

	public NodeExpr getLeft_expr() {
		return left_expr;
	}
	public void setLeft_expr(NodeExpr left_expr) {
		this.left_expr = left_expr;
	}
	public char getOperator() {
		return operator;
	}
	public void setOperator(char operator) {
		this.operator = operator;
	}
	public NodeExpr getRight_expr() {
		return right_expr;
	}
	public void setRight_expr(NodeExpr right_expr) {
		this.right_expr = right_expr;
	}
}
