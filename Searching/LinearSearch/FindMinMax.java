package pack.DSA.Week2.Searching.LinearSearch;

public class FindMinMax {

	public static void main(String[] args) {
		int[] nums = {29, 90, 89, 44, 92, 100, 38, 12, 9, 49};
		System.out.println("Min : " + min(nums));
		System.out.println("Max : " + max(nums));
	}
	
	static int min(int[] arr) {
		int min = Integer.MAX_VALUE;
		for(int idx : arr) {
			if(idx < min)
				min = idx;
		}
		return min;
	}
	
	static int max(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int idx : arr) {
			if(idx > max)
				max = idx;
		}
		return max;
	}
}
