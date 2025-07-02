package pack.DSA.Week6;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

	Deque<Integer> deq;
	Deque<Integer> minDeq;
	
	public static void main(String[] args) {
		MinStack min = new MinStack();
		
		min.push(2147483646);
		min.push(2147483646);
		min.push(2147483646);
		
		System.out.println(min.top());
		
		min.pop();
		
		System.out.println(min.getMin());
		
		min.pop();
		
		System.out.println(min.getMin());
		
		min.pop();
		
		min.push(2147483647);
		
		System.out.println(min.top());
		
		System.out.println(min.getMin());
		
		min.push(-2147483648);
		
		System.out.println(min.top());
		
		System.out.println(min.getMin());
		
		min.pop();
		
		System.out.println(min.getMin());
		
	}

	public MinStack() {
		deq = new ArrayDeque<>();
		minDeq = new ArrayDeque<>();
	}
	
	public void push(int val) {
		deq.addFirst(val);
		
		if(minDeq.isEmpty() || val <= minDeq.peekFirst()) {
			minDeq.addFirst(val);
		}
	}
	
	public void pop() {
        if(deq.peekFirst().equals(minDeq.peekFirst())) minDeq.removeFirst();
        
        deq.removeFirst();
    }
    
    public int top() {
        return deq.peekFirst();
    }
    
    public int getMin() {
        return minDeq.peekFirst();
    }
    
    @Override
	public String toString() {
		return "Stack [deq=" + deq + "]" +
				"\nMinStack [minDeq=" + minDeq + "]";
	}
}







