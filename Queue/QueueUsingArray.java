package pack.DSA.Week6.Queue;

import java.util.Arrays;

public class QueueUsingArray<T> {

	int start = -1, end = -1;
	int size, currentSize = 0;
	T[] array;
	
	@SuppressWarnings("unchecked")
	public QueueUsingArray(int size) {
		this.size = size;
		array = (T[]) new Object[size];
	}
	
	public void push(T obj) {
		if(currentSize == size) {
			System.out.println("Queue is full!!");
			return;
		}
		
		if(start == -1) {
			start = 0; end = 0;
		}
		
		array[end] = obj;
		end = (end + 1) % size;
		currentSize += 1;
	}
	
	public void pop() {
		if(currentSize == 0) {
			System.out.println("Queue is empty!1");
			return;
		}
		
		start = (start + 1) % size;
		currentSize -= 1;
	}
	
	public int size() {
		return currentSize;
	}
	
	public T top() throws Exception{
		if(currentSize == 0) {
			throw new Exception("Queue is empty!!");
		}
		
		return array[start];
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOf(array, currentSize));
	}
}







