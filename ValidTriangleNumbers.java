package pack.DSA.Week6;

import java.util.Arrays;

public class ValidTriangleNumbers {

	public static int triangleNumber(int[] nums) {
		// Write your code here
		Arrays.sort(nums);
		
		int n = nums.length;
		int count = 0;
		
		for(int k = n - 1; k >= 2; k--){
		    int idx = 0, jdx = k - 1;
		    
		    while(idx < jdx){
		    	if(nums[idx] + nums[jdx] > nums[k]) {
			        count += jdx - idx;
			        jdx -= 1;
			    }
			    
			    else{
			        idx += 1;
			    }
		    }
		}
		
		return count;
	}
	
}
