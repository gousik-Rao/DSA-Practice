package pack.DSA.Week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		System.out.println(nextLargeElement(new int[] {1, 3, 2, 4}));
	}
	
	static public ArrayList<Integer> nextLargeElement(int[] arr){
		Stack<Integer> st = new Stack<>();
		ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(arr.length, -1));                       
		
		for(int idx = 0; idx < arr.length; idx++) {
			while(!st.isEmpty() && arr[idx] > arr[st.peek()]) {
				int index = st.pop();
				res.set(index, arr[idx]);
			}
			st.push(idx);
		}
		return res;
	}
}
