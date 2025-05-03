package pack.DSA.Week4;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/problems/power-set4302/1

public class PowerSet {

	public static void main(String[] args) {
		String input = "abc";
		System.out.println(allPossibleStrings(input, input.length()));
	}
	
	static public List<String> allPossibleStrings(String input){
		StringBuilder sub = new StringBuilder();
		char[] ch = input.toCharArray();
		List<String> result = backtrack(0, sub, ch, new ArrayList<>());
		
		result.sort((a,b) -> a.compareTo(b));
		return result;
	}
	
	static private List<String> backtrack(int start, StringBuilder possibleStr, char[] ch, List<String> res){                                  
		if(start == ch.length) {
			return res;
		}
		
		for(int idx = start; idx < ch.length; idx++) {
			possibleStr.append(ch[idx]);
			res.add(possibleStr.toString());
			backtrack(idx + 1, possibleStr, ch, res);
			possibleStr.deleteCharAt(possibleStr.length() - 1);
		}
		
		return res;
	}
	
//	Using Bit Masking
	static public List<String> allPossibleStrings(String input, int n){
		List<String> res = new ArrayList<String>();
		
		for(int idx = 1; idx < (1 << n); idx++) {
			StringBuilder sub = new StringBuilder();
			for(int jdx = 0; jdx < n; jdx++) {
				if((idx & (1 << jdx)) != 0) {
					sub.append(input.charAt(jdx));
				}
			}
			res.add(sub.toString());
		}
		res.sort((a, b) -> a.compareTo(b));
		return res;
	}
}






















