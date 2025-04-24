package pack.DSA.Week3;

import java.util.HashMap;

public class SubstringWithKDistinct {

	public static void main(String[] args) {
		System.out.println(countSubstr("abaaca", 1));
	}
	
	static int countSubstr(String s, int k) {
        // your code here
        
        int count = countSubstringsWithAtMostK(k, s) - countSubstringsWithAtMostK(k - 1, s);             
        
        return count;
    }
	
	static int countSubstringsWithAtMostK(int k, String s) {
		
        int n = s.length();
        int result = 0;
        char[] ch = s.toCharArray();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int left = 0, right = 0; right < n; right++) {
        	map.put(ch[right], map.getOrDefault(ch[right], 0) + 1);
        	
        	while(map.size() > k) {
        		map.put(ch[left], map.get(ch[left]) - 1);
        		if(map.get(ch[left]) == 0) {
            		map.remove(ch[left]);
            	}
        		left++;
        	}
        	
        	result += (right - left) + 1;
        	
        }
        
        
        return result;
	}
}
