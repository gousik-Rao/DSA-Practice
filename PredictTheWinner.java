package pack.DSA.Week4;

public class PredictTheWinner {

	public static void main(String[] args) {
		System.out.println(predictTheWinner(new int[] {2, 4, 55, 6, 8}));
	}
	
	static public boolean predictTheWinner(int[] nums) {
		int[][] memo = new int[nums.length][nums.length];
		
		return maxDiff(0, nums.length - 1, nums, memo) >= 0;
    }	

	
	static int maxDiff(int left, int right, int[] nums, int[][] memo) {
		if(left == right)
			return nums[right];
        if(memo[left][right] != 0) return memo[left][right];
		
		int leftPick = nums[left] - maxDiff(left + 1, right, nums, memo);
		int rightPick = nums[right] - maxDiff(left, right - 1, nums, memo);   
		
		return memo[left][right] = Math.max((leftPick), (rightPick));                                    
	}
}
