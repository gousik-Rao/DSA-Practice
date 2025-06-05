package pack.DSA.Week6.Queue;

import java.util.Stack;

public class QueueUsingStack<T> {

	Stack<T> in = new Stack<>(), out = new Stack<>();
	
	public void push(T obj) {
		if(in.size() == 0 && out.size() == 0) {
			in.add(obj);
			return;
		}
		
//		Removing all elements from in and moving to out
		int inSize = in.size();
		while(inSize-- > 0) {
			out.add(in.pop());
		}
		in.add(obj); // Add the new element to the in stack
		
//		Then add the elements in the out stack again to in stack.
		int outSize = out.size();
		while(outSize-- > 0) in.add(out.pop());
	}
	
	public void pop() {
		if(in.isEmpty()) {
			System.out.println("Queue is empty!!");
			return;
		}
		in.pop();
	}
	
	public T top() {
		if(in.size() <= 0) {
			System.out.println("Queue is empty!!");
			return null;
		}
		return in.peek();
	}
	
	public int size() { return in.size(); }
	
	@Override
	public String toString() { return in.toString(); }
}
