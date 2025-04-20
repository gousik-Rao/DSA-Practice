package pack.DSA.Week3;

public class MaxCircularSubarraySum {

	public static void main(String[] args) {
		System.out.println(circularSubarraySum(new int [] {-1, 40, -14, 7, 6, 5, -4, -1}));
	}
	
	
//	Kadane's Algorithmic approach
	static public int circularSubarraySum(int arr[]) {

//      A modified Kadane's Algorithm to find the max sub array sum
		
//		Finding the max and min sub array sum using normal Kadane's Algorithm
        int maxSubarraySum = maxSubarraySum(arr);
        int minSubarraySum = minSubarraySum(arr);
        
        int totalArraySum = totalArraySum(arr);
        
//      To find the max sub array sum in a circular array, we subtract the min sub array sum from the total array sum,
//        and return the max of that and the max sub array sum.
        return totalArraySum == minSubarraySum ? maxSubarraySum : Math.max(totalArraySum - minSubarraySum, maxSubarraySum);
        
    }
	
	private static int totalArraySum(int[] arr) {
		int sum = 0;
		for(int idx = 0; idx < arr.length; idx++) {
			sum += arr[idx];
		}
		return sum;
	}
	
	private static int maxSubarraySum(int[] arr) {
		int globalMax = arr[0];
        int currentMax = arr[0];
        
        for(int idx = 1; idx < arr.length; idx++){
            currentMax = Math.max(arr[idx], arr[idx] + currentMax);
            globalMax = Math.max(currentMax, globalMax);
        }
        
        return globalMax;
	}
	
	private static int minSubarraySum(int[] arr) {
		int globalMin = arr[0];
        int currentMin = arr[0];
        
        for(int idx = 1; idx < arr.length; idx++){
            currentMin = Math.min(arr[idx], arr[idx] + currentMin);
            globalMin = Math.min(currentMin, globalMin);
        }
        
        return globalMin;
	}
}
