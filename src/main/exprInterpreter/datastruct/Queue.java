package main.exprInterpreter.datastruct;

public class Queue<T> {
	private Node<T> first;
	private int lenght;
	private Node<T> end;
	public Node<T> current;
	
	public Queue() {
		this.end = null;
		this.lenght = 0;
		this.first = null;
		this.current = null;
	}
	
	public void add(T value) {
		Node<T> new_node = new Node<>();
		new_node.setValue(value);
		if(this.isEmpty()) {
			this.first = new_node;
			this.end = new_node;
		} else {
			this.end.setPrev(new_node);
			this.end = new_node;
		}
		this.lenght++;
	}
	
	public int size() {
		return this.lenght;
	}
	
	public T pop() {
		if(!this.isEmpty()) {
			Node<T> current = this.first;
			this.first = this.first.getPrev();
			this.lenght--;
			return current.getValue();
			
		}
		return null;
	}

    public T getValue() {
        if(!this.isEmpty()) {
            return this.first.getValue();
        }
        return null;
    }

    public boolean isEmpty() {
        return this.first == null;
    }
	
	public boolean havePrev() {
		if(this.isEmpty()) {
			return false;
		} else if (this.current == null) {
			this.current = this.first;
			return true;
		} else {
			boolean havePrev = this.current.getPrev() != null;
			this.current = this.current.getPrev();
			return havePrev;
		}
	}
}
