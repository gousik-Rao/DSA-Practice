package pack.DSA.Week2.Searching.LinearSearch;

public class SearchInRange {

	public static void main(String[] args) {
		int[] nums = {29, 90, 89, 44, 92, 100, 38, 12, 9, 49};
		int target = 9;
		System.out.println(linearSearch(nums, target, 1, 4));
	}
	
	static int linearSearch(int[] arr, int target, int start, int end) {
		if(arr.length == 0) {
			return -1;
		}
		
		for(int idx = start; idx < end; idx++) {
			if(target == arr[idx]) {
				return idx;
			}
		}
		return -1;
	}
}
