package pack.DSA.Week6;

public class Node<T> {
	public T value;
	public Node<T> next;
	
	public Node(T val) {
		this.value = val;
		this.next = null;
	}
	
	@Override
	public String toString() {
		return next + " -> " + value;
	}
}
