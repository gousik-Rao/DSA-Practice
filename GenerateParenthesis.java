package pack.DSA.Week4;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	
	public static void main(String... args) {
		System.out.println(generateParenthesis(3));
	}
	
	static public List<String> generateParenthesis(int n){
		return backtrack(new StringBuilder(), 0, 0, new ArrayList<String> (), n);
	}
	
	static List<String> backtrack(StringBuilder currentString, int openCount, int closeCount, List<String> res, int n){                   
		if(openCount == n && closeCount == n) {
			res.add(currentString.toString());
			return res;
		}
		
		if(openCount < n) {
			backtrack(currentString.append("("), openCount + 1, closeCount, res, n);
			currentString.deleteCharAt(currentString.length() - 1);
		}
		if(closeCount < openCount) {
			backtrack(currentString.append(")"), openCount, closeCount + 1, res, n);
			currentString.deleteCharAt(currentString.length() - 1);
		}
		
		return res;
	}
}
