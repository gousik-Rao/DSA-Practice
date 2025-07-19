package pack.DSA.Week2.Searching.LinearSearch;

public class Main {

	public static void main(String[] args) {
		int[] nums = {29, 90, 89, 44, 92, 100, 38, 12, 9, 49};
		int target = 100;
		int result = linearSearch(nums, target);
		String string = result != -1 ? " is at index : " : " is not in the array, hence returned ";
		System.out.println(target + string + result);
	}
	
//	Search in the array: return the index if item found
//	Otherwise if item is not found return -1
	static int linearSearch(int[] arr, int target) {
		if(arr.length == 0) {
			return -1;
		}
		
		for(int idx = 0; idx < arr.length; idx++) {
			if(target == arr[idx]) {
				return idx;
			}
		}
		return -1;
	}
	
//	Search in the array: return the item if item found
//	Otherwise if item is not found return -1
	static int linearSearch2(int[] arr, int target) {
		if(arr.length == 0) {
			return Integer.MAX_VALUE;
		}
		
		for(int idx : arr) {
			if(target == idx) {
				return idx;
			}
		}
		return Integer.MAX_VALUE;
	}
}
