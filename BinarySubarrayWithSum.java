package pack.DSA.Week5;

public class BinarySubarrayWithSum {

	public static void main(String[] args) {
		System.out.println(numSubarraysWithSum(
				new int[] {0, 0, 0, 0, 0,}, 0) - 
				numSubarraysWithSum(
						new int[] {0, 0, 0, 0, 0,}, 0 - 1));                           
	}
	
//	At-most trick!!
	static public int numSubarraysWithSum(int[] nums, int goal) {
        int s = 0, e = 0, n = nums.length;
        int sum = 0, count = 0;

        while(s < n && e < n){
//        	Expand window to the right
            sum += nums[e];
            
            while(s <= e && sum > goal) {
//            	Shrink if given condition is not satisfied
            	sum -= nums[s];
            	s++;
            }
            
//          Core point
            count += e - s + 1;
            e++;
        }
        
        return count;
    }
}
