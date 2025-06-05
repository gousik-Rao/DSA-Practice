package pack.DSA.Week6.Stack;

import pack.DSA.Week6.Node;

@SuppressWarnings("unused")
public class StackUsingLinkedList<T> {

	public Node<T> top;
	public int size;
	
	public StackUsingLinkedList(){
		this.top = null;
		this.size = 0;
	}
	
//	All operations are in constant time
//	and space complexity refers to the space used for the nodes.
	
	public void push(T obj) {
		Node<T> temp = new Node<>(obj);
		temp.next = top;
		top = temp;
		
		size += 1;
	}
	
	public void pop() {
		if(top == null) return;
		Node<T> temp = top;
		top = top.next;
		temp = null;
		size -= 1;
	}
	
	public T top() {
		if(top == null) return null;
		return top.value;
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		return top.toString();
	}
}
