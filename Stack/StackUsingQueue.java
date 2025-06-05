package pack.DSA.Week6.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue<T> {

	Queue<T> que = new LinkedList<>();
	
	public void push(T obj) {
		int size = que.size();
		que.add(obj);
		
//		Since we want stack behavior, when we add a new element we take all the previous elements in the queue                      
//		and add it next to the recently inserted element, simulating stack behavior
		while(size-- > 0) que.add(que.poll());
	}
	
	public void pop() {
		if(que.size() <= 0) return;
		que.poll();
	}
	
	public T top() {
		if(que.isEmpty()) return null;
		return que.peek();
	}
	
	public int size() {
		return que.size();
	}
	
	@Override
	public String toString() {
		return que.toString();
	}
}
