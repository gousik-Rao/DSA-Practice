package pack.DSA.Week5;

public class NiceSubarraysCount {
	
	public static void main(String[] args) {
		System.out.println(numberOfSubarrays(2, new int[] {2,2,2,1,2,2,1,2,2,2}));
	}
	
	static public int numberOfSubarrays(int k ,int[] arr) {
		if(arr.length < k) return 0;
		
		return oddSubarrays(k, arr) - oddSubarrays(k - 1, arr);
	}

	static private int oddSubarrays(int k, int[] arr) {
		int s = 0, e = 0;
		int oddCount = 0, count = 0;
		
		for(; e < arr.length;) {
//			Expand he window by including the next element arr[e]
			if((arr[e] & 1) == 1) {
				oddCount++;
			}
			
//			Shrink from left until the odd count becomes <= k
			while(oddCount > k) {
				oddCount--;
				s++;
			}
			
//			At this point, window [s...e] has at most k odd numbers
//	        So count all subarrays ending at `e` and starting from `s` to `e`                        
			count += e - s + 1;
			
//			Moving to next element			
			e++;
		}
		
		return count;
	}
}
