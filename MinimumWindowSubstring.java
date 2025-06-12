package pack.DSA.Week5;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}
	
	static public String minWindow(String str, String t) {
		int l = 0, r = 0, m = str.length(), n = t.length();
		int count = 0, minLen = Integer.MAX_VALUE, startIndex = -1;
		int[] hash = new int[256];
		
//		Pre inserting t string characters
		for(int idx = 0; idx < n; idx++) {
			hash[t.charAt(idx)]++;
		}
		
		while(r < m) {
			
//			Expand to the right by adding new element
			hash[str.charAt(r)]--;
			if(hash[str.charAt(r)] >= 0) {
				count++;
			}
			
//			Try to shrink from the left, still keeping the window valid
			while(count == n) {
				if((r - l + 1) < minLen) {
					minLen = r - l + 1;
					startIndex = l;
				}
				
				// Restore the character at left back to hash
                hash[str.charAt(l)]++;
                if (hash[str.charAt(l)] > 0) {
                    count--; // We lost a required character
                }
                
				l = l + 1; // Shrink from left
			}
			r = r + 1; // Expand towards right end
		}
		
		return startIndex == -1 ? "" : str.substring(startIndex, startIndex + minLen);                        
	}
}
















