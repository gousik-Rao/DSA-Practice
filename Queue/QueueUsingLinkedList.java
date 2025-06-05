package pack.DSA.Week6.Queue;

import pack.DSA.Week6.*;

public class QueueUsingLinkedList<T> {

	Node<T> head, tail;
	int size;
	
	public QueueUsingLinkedList(){
		head = tail = null;
		size = 0;
	}
	
	public void push(T obj) {
		Node<T> temp = new Node<>(obj);
		if(head == null) head = tail = temp;
		else {
			tail.next = temp;
			tail = temp;
		}
		size += 1;
	}
	
	public void pop() {
		if(head == null) return;
		head = head.next;
		if(head == null) tail = null;
		size -= 1;
	}
	
	public T top() {
		if(head == null) return null;
		return head.value;
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		return tail + " -> " + tail.next;
	}
}


