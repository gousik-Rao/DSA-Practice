package pack.DSA.Week3;

import java.util.Stack;

public class ParanthesisChecker {

	public static void main(String[] args) {
		System.out.println(isBalanced("[[[["));
	}
	
	static boolean isBalanced(String s) {
        // code here
        int n = s.length();
        if(n % 2 != 0){
            return false;
        }
        
        Stack<Character> st = new Stack<>();
        char[] ch = s.toCharArray();
        
        for(int idx = 0; idx < ch.length; idx++) {
        	if(st.empty()) {
        		if(ch[idx] == '}' || ch[idx] == ']' || ch[idx] == ')') {
            		return false;
            	}
        	}
        	
        	if(ch[idx] == '{' || ch[idx] == '(' || ch[idx] == '[') {
        		st.add(ch[idx]);
        	}else if(ch[idx] == '}') {
        		if(st.peek() == '{') st.pop();
        		else	return false;
        	}else if(ch[idx] == ')') {
        		if(st.peek() == '(') st.pop();
        		else return false;
        	}else if(ch[idx] == ']') {
        		if(st.peek() == '[') st.pop();
        		else return false;
        	}
        }
        
        return st.empty() ? true : false;
    }
}
