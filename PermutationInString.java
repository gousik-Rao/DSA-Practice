package pack.DSA.Week3;

import java.util.Arrays;

public class PermutationInString {

	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "diobaok"));
		System.out.println(checkInclusion("ab", "dioboak"));
	}
	
	static public boolean checkInclusion(String s1, String s2) {
	 	if(s1.length() > s2.length())
			return false;
		
//	 	Using int[26] method
	 	
	 	int s1Length = s1.length(), s2Length = s2.length();
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        
        for(int idx = 0; idx < s1Length; idx++) {
        	s1Freq[s1.charAt(idx) - 'a']++;
        }
        
        for(int idx = 0; idx < s2Length; idx++) {
        	s2Freq[s2.charAt(idx) - 'a']++;
        	
//        	Shrink the window size if it is larger than S1
        	if(idx >= s1Length) {
        		s2Freq[s2.charAt(idx - s1Length) - 'a']--;
        	}
        	
//        	Check if the 2 arrays are same
        	if(Arrays.equals(s1Freq, s2Freq)) {
        		return true;
        	}
        }
        return false;
        
//        Using Map approach (Inefficient)
        
//        Map<Character, Integer> s1Map = new HashMap<>();
//
//        for(int idx = 0; idx < charS1.length; idx++){
//        	s1Map.put(charS1[idx], s1Map.getOrDefault(charS1[idx], 0) + 1);
//        }
//        
//        Map<Character, Integer> s2Map = new HashMap<>();
//
//        for (int idx = 0; idx < s2.length(); idx++) {
//        	s2Map.put(charS2[idx], s2Map.getOrDefault(charS2[idx], 0) + 1);
//        	
//        	if(idx >= s1.length()) {
//        		char characterToRemove = s2.charAt(idx - s1.length());
//        		s2Map.put(characterToRemove, s2Map.get(characterToRemove) - 1);
//        		if(s2Map.get(characterToRemove) == 0) {
//        			s2Map.remove(characterToRemove);
//        		}
//        	}
//        	
//        	if(idx >= s1.length() - 1) {
//        		if(s1Map.equals(s2Map)) {
//        			return true;
//        		}
//        	}
//        }
//        return false;
    }
}
