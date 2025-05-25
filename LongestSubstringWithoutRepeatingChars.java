package pack.DSA.Week5;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("gousik"));
	}
	
	static public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        if(n <= 0) return 0;
        if(n == 1) return 1;

        char[] chArr = s.toCharArray();
        int maxLength = 0;

        int i = 0, j = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        
        while(i < n && j < n){
            if(charMap.containsKey(chArr[j])){
                i = Math.max(i, charMap.get(chArr[j]) + 1);
                charMap.put(chArr[j], j);
            }
            else charMap.put(chArr[j], j);
            
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;
    }
}
