package pack.DSA.Week4;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakUseTrie {

	public static void main(String[] args) {
		List<String> wordDict = List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
		
		System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", wordDict));
	}
	
	static public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> dictSet = new LinkedHashSet<>(wordDict);
		Map<Integer, Boolean> memo = new HashMap<>();
		
        return canBreak(s, dictSet, 0, memo);
    }
	
	static private boolean canBreak(String s, Set<String> dict, int start, Map<Integer, Boolean> memo) {
		if(start == s.length())
			return true;
		
//		Using memoization for efficiency
		if(memo.containsKey(start)) {
			return memo.get(start);
		}
		
		for(int end = start + 1; end <= s.length(); end++) {
			if(dict.contains(s.substring(start, end)) && canBreak(s, dict, end, memo)) {
				memo.put(start, true);
				return true;
			}
		}
		
		memo.put(start, false);
		return false;
	}
	
	
//	Brute force
	static boolean check(String s, List<String> dict, int start, int end) {
		int idx = 0;
		while(start < end && idx < dict.size()) {
			String fromList = dict.get(idx);
			
			if(!s.substring(start, start + fromList.length()).equals(fromList)) {                              
				return false;
			}
			idx++;
			start += fromList.length();
		}
		
		return true;
	}
}
