package pack.DSA.Week5;

public class MaxPointsObtainFromCards {
	
	public static void main(String[] args) {
		System.out.println(maxScore(new int[] {9, 7, 7, 9, 7, 7, 9}, 7));
	}
	
//	Taking elements from the front and the back
	static public int maxiScore(int[] arr, int k) {
		int lSum = 0, rSum = 0, maxSum = 0;
		
		for(int idx = 0; idx < k; idx++) lSum += arr[idx];
		
		maxSum = lSum;
		
		for(int idx = 1; idx <= k; idx++) {
			lSum -= arr[k - idx];
			
			rSum += arr[arr.length - idx];
						
			maxSum = Math.max(rSum, lSum);
		}
		
		return maxSum;
	}

//	With window size of n - k
	static public int maxScore(int[] arr, int k) {
		int n = arr.length;
		int i = 0, j = n - k;
		int totalSum = 0;
		
//		Getting the total sum
		for(int idx = i; idx < n; idx++) totalSum += arr[idx];
		
		int windowLength = 0, minWindowLength = 0;
		for(int idx = 0; idx < j; idx++) windowLength += arr[idx];
		
		while(j < n) {
			windowLength = windowLength - arr[i] + arr[j];
			
			minWindowLength = Math.min(windowLength, minWindowLength);
			i++;j++;
		}
		
		return totalSum - minWindowLength;
	}
}
