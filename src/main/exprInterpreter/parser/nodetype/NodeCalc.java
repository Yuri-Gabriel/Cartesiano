package main.exprInterpreter.parser.nodetype;

import java.util.Objects;

public final class NodeCalc implements NodeExprValue {
	private NodeCalc prev_calc;
	private NodeExpr left_expr;
	private char operator;
	private NodeExpr right_expr;

	public NodeCalc(NodeCalc prev_calc ,NodeExpr left_expr, char operator, NodeExpr right_expr) {
		this.prev_calc = prev_calc;
		this.left_expr = left_expr;
		this.operator = operator;
		this.right_expr = right_expr;
	}
	
	public NodeCalc() {
		this.prev_calc = null;
		this.left_expr = null;
		this.operator = ' ';
		this.right_expr = null;
	}

	public NodeCalc getPrev_calc() {
		return prev_calc;
	}

	public void setPrev_calc(NodeCalc prev_calc) {
		this.prev_calc = prev_calc;
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

	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NodeCalc other = (NodeCalc) obj;
        return this.operator == other.operator &&
               this.left_expr.equals(other.left_expr) &&
               this.right_expr.equals(other.right_expr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left_expr, operator, right_expr);
    }
}
