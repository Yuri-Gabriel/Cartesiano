package main.exprInterpreter.datastruct.linkedlist;

public class Node<T> {
	private T value;
    private Node<T> next;
    private Node<T> prev;

    public Node() {
        this.next = null;
        this.prev = null;
        this.value = null;
    }

    public T getValue() {
        return this.value;
    }
    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return this.prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}
