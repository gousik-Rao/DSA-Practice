package pack.DSA.Week6.Stack;

import java.util.Arrays;

public class StackUsingArray<T> {

	int pointer = -1, size = 0;
	int currentSize = 0;
	T[] array;

	@SuppressWarnings("unchecked")
	public StackUsingArray(int obj) {
		size = obj;
		array = (T[]) new Object[size];
	}
	
	public void push(T obj) {
		if(currentSize == size) {
			System.out.println("Stack is full!");
			return;
		}
		pointer += 1;
		array[pointer] = obj;
		currentSize += 1;
	}
	
	public void pop() {
		if(currentSize == 0) {
			System.out.println("Stack is empty!!");
			return;
		}
		pointer -= 1;
		currentSize -= 1;
	}
	
	public T top() throws Exception {
		if(currentSize == 0) {
			System.out.println("Stack is empty!");
			throw new Exception("Stack is empty");
		}
		return (T) array[pointer];
	}
	
	public int size() {
		return currentSize;
	}
	
	
	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOf(array, currentSize));
	}
}
