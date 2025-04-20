package pack.DSA.Week3;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] {-2, 0, -1}));
	}
	
//	Using a Dynamic Approach (Dynamic Programming)
	static public int maxProduct(int[] nums) {
        int maxProduct = nums[0]; // To track the max product
        int minProduct = nums[0]; // Tracking the min product to handle negative numbers
        int result = nums[0]; // We greedily assume the first element will be the result initially
        
        for(int idx = 1; idx < nums.length; idx++) {
        	maxProduct = Math.max(nums[idx], Math.max(nums[idx] * maxProduct, nums[idx] * minProduct));                      
        	minProduct = Math.min(nums[idx], Math.min(nums[idx] * maxProduct, nums[idx] * minProduct));
        	
        	result = Math.max(maxProduct, result);
        }
        
        return result;
	}
}
