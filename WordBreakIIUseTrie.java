package pack.DSA.Week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakIIUseTrie {
	
	public static void main(String[] args) {
		List<String> wordDict = List.of("cat", "cats", "and", "sand", "dog");
		String s = "catsanddog";
		
		System.out.println(wordBreak(s, wordDict));
	}
	
	static public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<Integer,  List<String>> memo = new HashMap<>();
        
        
        
        return checkBreak(s, set, 0, memo);
    }
	
	public static List<String> checkBreak(String s, Set<String> dict, int start, Map<Integer, List<String>> memo) {                                    
		if(start == s.length()) {
			return List.of("");
		}
		
//		Memoization for efficiency
		if(memo.containsKey(start)) return memo.get(start);
				
		List<String> result = new ArrayList<String>();
		
		for(int end = start + 1; end <= s.length(); end++) {
			String prefix = s.substring(start, end);
			
			if(dict.contains(prefix)) {
				
				List<String> subSentence = checkBreak(s, dict, end, memo);
				
				for(String sub : subSentence) {
					if(sub.isEmpty()) {
						result.add(prefix);
					}else {
						result.add(prefix + " " + sub);
					}
				}
			}
		}
		
		memo.put(start, result);
		
		return result;
	}
}












