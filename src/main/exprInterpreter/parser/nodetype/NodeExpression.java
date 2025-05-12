package main.exprInterpreter.parser.nodetype;

import main.exprInterpreter.token.Token;

public final class NodeExpression implements NodeTermType {
    private NodeTerm left;
    private Token operation;
    private NodeTerm right;

    public NodeExpression() { }

    public NodeTerm getLeft() {
        return left;
    }

    public void setLeft(NodeTerm left) {
        this.left = left;
    }

    public Token getOperation() {
        return operation;
    }

    public void setOperation(Token operation) {
        this.operation = operation;
    }

    public NodeTerm getRight() {
        return right;
    }

    public void setRight(NodeTerm right) {
        this.right = right;
    }
}
