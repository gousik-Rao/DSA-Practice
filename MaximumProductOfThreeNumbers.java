package pack.DSA.Week6;

public class MaximumProductOfThreeNumbers {

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] {-13, -10, -20, 3, 4, 5}));
	}
	
	static public int maxProduct(int[] nums) {
		int max1 = Integer.MIN_VALUE, max2 = max1, max3 = max1;
		int min1 = Integer.MAX_VALUE, min2 = min1;
		
		for(int num : nums) {
			if(num > max1) {
				max3 = max2;
				max2 = max1;
				max1 = num;
			}else if(num > max2) {
				max3 = max2;
				max2 = num;
			}else if(num > max3) max3 = num;
			
			if(num < min1) {
				min2 = min1;
				min1 = num;
			}else if(num < min2) {
				min2 = num;
			}
		}
		
		return Math.max(max3 * max2 * max1, 
						min2 * min1 * max1);
	}
}
