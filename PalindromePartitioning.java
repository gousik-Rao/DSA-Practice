package pack.DSA.Week4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PalindromePartitioning {
	
	public static void main(String[] args) {
		System.out.println(partition("aab"));
	}
	
	static public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        
        palindromePartitionCheck(s, 0, result, new ArrayList<>());
        
        return result;
    }
	
	static private void palindromePartitionCheck(String s, int start, List<List<String>> res, List<String> tempRes) {                     
		if(start == s.length()) {
			res.add(new ArrayList<>(tempRes));
			return; // When start reaches the end of string                             
		}
				
		for(int end = start + 1; end <= s.length(); end++) {
			String sub = s.substring(start, end);
						
			if(isPalindrome(sub)) {
				tempRes.add(sub);
				palindromePartitionCheck(s, end, res, tempRes);
				
				tempRes.remove(tempRes.size() - 1);
			}	
		}	
	}

	static private boolean isPalindrome(String sub) {
		
//		Java Streams
		return IntStream.range(0, sub.length() >> 1)
				.noneMatch(idx -> sub.charAt(idx) != sub.charAt(sub.length() - idx - 1));
		
//		Traditional Way
		
//		if(sub.length() == 1) {
//			return true;
//		}
//		
//		int start = 0, end = sub.length() - 1;
//		
//		while(start < end) {
//			if(sub.charAt(start) != sub.charAt(end)) {
//				return false;
//			}
//			
//			start++; end--;
//		}
//		
//		return true;
	}
}
