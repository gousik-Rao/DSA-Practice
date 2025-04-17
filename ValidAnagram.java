package pack.DSA.Week3;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        
        for(int idx = 0; idx < charS.length; idx++) {
        	if(sMap.containsKey(charS[idx])) {
        		sMap.put(charS[idx], sMap.get(charS[idx]) + 1);
        	}else {
        		sMap.put(charS[idx], 1);
        	}
        	
        	if(tMap.containsKey(charT[idx])) {
        		tMap.put(charT[idx], tMap.get(charT[idx]) + 1);
        	}else {
        		tMap.put(charT[idx], 1);
        	}
        }
        
        int size = sMap.size();
        for(int idx = 0; idx < size; idx++) {
        	if(sMap.get(charS[idx]) != tMap.get(charT[idx])) {
        		return false;
        	}
        }

        return true;
    }
}
