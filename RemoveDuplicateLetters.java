package pack.DSA.Week6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicateLetters {

	public static void main(String[] args) {
		System.out.println(removeDuplicates("ecbacba"));
	}
	
	static public String removeDuplicates(String str) {
		Map<Character, Integer> map = new HashMap<>();
		Deque<Character> st = new ArrayDeque<>();
		Set<Character> set = new HashSet<>();
		
		int n = str.length();
		char[] ch = str.toCharArray();
		for(int idx = 0; idx < n; idx++) {
			map.put(ch[idx], idx);
		}
		
		for(int idx = 0; idx < n; idx++){
			if(set.contains(ch[idx])) continue;

			while(!st.isEmpty() && ch[idx] < st.peek()
					&& map.get(st.peek()) > idx) {
				set.remove(st.peek());
				st.remove();
			}
			st.addFirst(ch[idx]);
			set.add(ch[idx]);
		}
		
		StringBuilder res = new StringBuilder();
		while(!st.isEmpty()) res.append(st.removeLast());
//		for(char c : st) {
//			res.insert(0, c);
//		}
		
		System.out.println(map);
		return res.toString();
	}
}
