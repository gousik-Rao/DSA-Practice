package pack.DSA.Week3;

public class KadaneAlgorithm {

	public int maxSubarraySum(int[] arr) {
		int currentMax = arr[0];
		int ogMax = arr[0];
		
		for(int idx = 1; idx < arr.length; idx++) {
			currentMax = Math.max(arr[idx], currentMax + arr[idx]);
			ogMax = Math.max(ogMax, currentMax);
		}
		
		return ogMax;
	}
}
