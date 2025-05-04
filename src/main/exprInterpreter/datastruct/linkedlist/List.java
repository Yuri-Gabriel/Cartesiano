package main.exprInterpreter.datastruct.linkedlist;

public class List<T> {
	private Node<T> head;
	private Node<T> end;
	private Node<T> current;
	
	public void add(T value) {
		Node<T> new_node = new Node<T>();
		new_node.setValue(value);
		if(this.head == null && this.end == null) {
			this.head = new_node;
			this.end = new_node;
		} else if(this.end.getNext() == null) {
			new_node.setPrev(this.end);
			this.end.setNext(new_node);
			this.end = new_node;
		}
	}
	
	public boolean haveNext() {
		if(this.head == null) {
			return false;
		} else if (this.current == null) {
			this.current = this.head;
			return true;
		} else {
			boolean haveNext = this.current.getNext() != null;
			this.current = this.current.getNext();
			return haveNext;
		}
	}
	
	public boolean isEmpty() {
		return this.head == null;

	}

	public Node<T> getCurrent() {
		return this.current;
	}
}
