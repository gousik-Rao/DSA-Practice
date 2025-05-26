package pack.DSA.Week5;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
	
	public int characterReplacementUseInt26(String str, int k) {
		int n = str.length();
		int s = 0, e = 0;
		int maxFreq = 0, maxLen = 0;
		int[] charTrack = new int[26];
		
		while(s < n && e < n) {
			int chValue = str.charAt(e) - 'A';
			charTrack[chValue]++;
			
			maxFreq = Math.max(maxFreq, charTrack[chValue]);
			int windowSize = e - s + 1;
			
			if(windowSize - maxFreq > k) {
				charTrack[str.charAt(s) - 'A']--;
				s++;
			}else {
				maxLen = Math.max(maxLen, windowSize);
			}
			e++;
		}
		
		return maxLen;
	}
	
	public int characterReplacementUseMap(String str, int k) {
        int n = str.length();
        int s = 0, e = 0;
        int maxFreq = 0, maxLen = 0;        
        Map<Character, Integer> freqMap = new HashMap<>();

        while(s < n && e < n){
            freqMap.put(str.charAt(e), freqMap.getOrDefault(str.charAt(e), 0) + 1);            

            maxFreq = Collections.max(freqMap.values());
            int windowLen = e - s + 1;
            
            if((windowLen) - maxFreq > k){
                freqMap.put(str.charAt(s), freqMap.get(str.charAt(s)) - 1);
                s++;
            } else {
                maxLen = Math.max(windowLen, maxLen);
            }
            e++;
        }

        
        return maxLen;
    }
	
	static public int majorityElement(int[] nums) {
		// write your code here
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int idx = 0; idx < nums.length; idx++){
		    map.put(nums[idx], map.getOrDefault(nums[idx], 0) + 1);
		}
		
		System.out.println(map);
		int majorElem = 0, currMax = 0;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
		    int major = entry.getValue();
		    
		    if(major > currMax){
		    	currMax = major;
		        majorElem =  entry.getKey();
		    }
		}
		
		return majorElem;
	}
	
	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] {4, 2, 4}));
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
