package main.exprInterpreter.datastruct.linkedlist;

public class Node<T> {
	private T value;
    private Node<T> next;
    private Node<T> prev;
    private int index;

    public Node() {
        this.next = null;
        this.prev = null;
        this.value = null;
        this.index = 0;
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

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
