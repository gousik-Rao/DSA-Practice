package pack.DSA.Week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagramsInAString {

	public static void main(String[] args) {
		System.out.println(findAnagram("abacaabagfrkbaacjkcbaa", "aabc"));
	}
	
//	Using Integer 26 for more efficient way
	static public List<Integer> findAnagram(String s, String p){
		List<Integer> res = new ArrayList<>();
		int sLen = s.length(), pLen = p.length();
		
		if(sLen < pLen) return res;
		
		int[] sFreq = new int[26];
		int[] pFreq = new int[26];
		
//		Frequency for p and the initial window
		for(int idx = 0; idx < pLen; idx++) {
			sFreq[s.charAt(idx) - 'a']++;
			pFreq[p.charAt(idx) - 'a']++;
		}
		
//		Check for the first window match with the string p
		if(Arrays.equals(sFreq, pFreq)) res.add(0);
		
//		Sliding window kicks off
		for(int idx = pLen; idx < sLen; idx++) {
			sFreq[s.charAt(idx) - 'a']++; // Adding the next character value
			sFreq[s.charAt(idx - pLen) - 'a']--;
			
			if(Arrays.equals(sFreq, pFreq)) res.add(idx - pLen + 1);
		}
		
		return res;
	}
	
//	Using Maps less efficient
	static public List<Integer> findAnagrams(String s, String p) {
        int st = 0, e = p.length();
        int n = s.length();
        List<Integer> res = new ArrayList<>();
        
        Map<Character, Integer> sMap = new HashMap<>();
        char[] chS = s.toCharArray();
        for(int idx = st; idx < e; idx++) {
        	sMap.put(chS[idx], sMap.getOrDefault(chS[idx], 0) + 1);
        }
        
        Map<Character, Integer> pMap = new HashMap<>();
        char[] chP = p.toCharArray();
        for(char ch : chP) {
        	pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }
        
//      System.out.println(pMap);
//    	System.out.println(sMap);
        
        while(e < n){
        	if(sMap.equals(pMap)) {
        		res.add(st);
        	}
//        	System.out.println(pMap);
//        	System.out.println(e);
        	
//        	Removing first element
        	sMap.put(chS[st], sMap.get(chS[st]) - 1);
        	if(sMap.get(chS[st]) == 0) sMap.remove(chS[st]);
        	
//        	Adding the next element
        	sMap.put(chS[e], sMap.getOrDefault(chS[e], 0) + 1);
        	st++;e++;
        }
        
        if(e == n) {
        	if(sMap.equals(pMap)) {
        		res.add(st);
        	}
        }
        return res;
    }
}
