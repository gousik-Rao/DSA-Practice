package pack.DSA.Week2;

import java.util.Stack;

public class BalancedParenthesis {

	static boolean isBalancedParentheses(String str) {
	    // add your logic here
		if(str == null || str.length() <= 1){
			return false;
		}
		if(str.equals(""))
			return true;
		
		Stack<Character> stack = new Stack<>();
		for(int idx = 0; idx < str.length(); idx++){
			if(str.charAt(idx) == '(' || str.charAt(idx) == '[' || str.charAt(idx) == '{'){                           
				stack.push(str.charAt(idx));
			}else {
				if(stack.empty())
					return false;
				if((stack.peek() == '(' && str.charAt(idx) == ')') || 
					(stack.peek() == '{' && str.charAt(idx) == '}') ||
			 		 (stack.peek() == '[' && str.charAt(idx) == ']')) {
					stack.pop();
				}else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
