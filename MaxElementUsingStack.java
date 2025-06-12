package pack.DSA.Week6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxElementUsingStack {
	
	public static List<Integer> getMax(List<String> operations) {
	    // Write your code here
	        Stack<Integer> st = new Stack<>();
	        Stack<Integer> maxSt = new Stack<Integer>();
	        List<Integer> res = new ArrayList<>();
	        
	        for(String operate : operations){
	        	String[] ops = operate.split(" ");
	        	
	            int command = Integer.parseInt(ops[0]);
	            
	            if(command == 1) {
	            	int num = Integer.parseInt(ops[1]);
	            	st.push(num);
	            	maxSt.add(Math.max(num, maxSt.peek()));
	            }else if(command == 1) {
	            	if(!st.isEmpty()) st.pop();
	            }
	            else if(command == 3) {
	            	if(!st.isEmpty()) res.add(st.peek());
	            }
	        }
	        
	        return res;
	    }
}
