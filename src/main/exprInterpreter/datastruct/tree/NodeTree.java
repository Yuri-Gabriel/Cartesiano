package main.exprInterpreter.datastruct.tree;

public class NodeTree<T> {
	private T value;
	private NodeTree<T> nodeLeft;
	private NodeTree<T> nodeRight;
	
	public NodeTree(T value) {
		this.setValue(value);
		this.setNodeLeft(null);
		this.setNodeRight(null);
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}

	public NodeTree<T> getNodeLeft() {
		return nodeLeft;
	}

	public void setNodeLeft(NodeTree<T> nodeLeft) {
		this.nodeLeft = nodeLeft;
	}

	public NodeTree<T> getNodeRight() {
		return nodeRight;
	}

	public void setNodeRight(NodeTree<T> nodeRight) {
		this.nodeRight = nodeRight;
	}
	
	
	
}
