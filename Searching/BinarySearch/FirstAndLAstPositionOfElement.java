package pack.DSA.Week2.Searching.BinarySearch;

import java.util.Arrays;

public class FirstAndLAstPositionOfElement {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[] {5, 7, 7, 8, 8, 10}, 10)));
	}
	
	static public int[] searchRange(int[] nums, int target) {
		if(nums.length < 0) return new int[] {-1, -1};
		
		int left = 0, right = nums.length - 1;
		
		int[] res = new int[2];
		
		res[0] = firstOcc(nums, left, right, target, -1);
		res[1] = lastOcc(nums, left, right, target, -1);
		
		if(res[0] == -1 && res[1] != -1) {
			res[0] = res[1];
		}else if(res[1] == -1 && res[0] != -1) {
			res[1] = res[0];
		}
		
		return res;
	}

	private static int firstOcc(int[] nums, int left, int right, int target, int res) {                                                        
		
		if(left > right) return res;
		int mid = left + ((right - left) >> 1);
		
		if(target == nums[mid]) {
			res = mid;
			return firstOcc(nums, left, mid - 1, target, res);
		}else if(target < nums[mid]) {
			return firstOcc(nums, left, mid - 1, target, res);
		}else 
			return firstOcc(nums, mid + 1, right, target, res);		
	}

	private static int lastOcc(int[] nums, int left, int right, int target, int res) {
		if(left > right) return res;
		
		int mid = left + ((right - left) >> 1);
		
		if(target == nums[mid]) {
			res = mid;
			return lastOcc(nums, mid + 1, right, target, res);
		}else if(target > nums[mid]) {
			return lastOcc(nums, mid + 1, right, target, res);
		}else 
			return lastOcc(nums, left, mid - 1, target, res);
		
	}
	
}
