package pack.DSA.Week3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortingCharacterByFrequency {

	public static void main(String[] args) {
		System.out.println(freQuencySort("treee"));
	}
	
	public static String freQuencySort(String s) {
		char[] ch = s.toCharArray();
		StringBuilder res = new StringBuilder();
		Map<Character, Integer> map = new LinkedHashMap<>();
		
		for(char c : ch) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());                             

		list.sort((a, b) -> a.getValue() > b.getValue() ? -1 : 
							a.getValue() < b.getValue() ? 1 : 0);
		
		System.out.println(list);
		
		for(Map.Entry<Character, Integer> entry : list) {
			res.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
		}
		
		return res.toString();
	}
}
