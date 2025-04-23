package pack.DSA.Week3;

import java.util.Arrays;

public class RearrangeArrayAlternatively {

	public static void main(String[] args) {
		int[] arr = {891, 71, 185, 651, 518};
		
		rearrangeArray(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	static void rearrangeArray(int[] arr) {
		if(arr.length == 1)
			return;
		Arrays.sort(arr);
		
//		In - Place approach using math formula - oldValue + (newValue % M) / M                        
//																		M -> maxArrayValue + 1
		int n = arr.length;
		int maxIdx = n - 1, minIdx = 0;
		int M = arr[maxIdx] + 1; // Any number greater than the maximum element in the array
		for(int idx = 0; idx < n; idx++) {
			if(idx % 2 == 0) {
				arr[idx] += (arr[maxIdx] % M) * M; // We take % M, to get the old value in this index as it may have been encoded             
				maxIdx--;
			}else {
				arr[idx] += (arr[minIdx] % M) * M;
				minIdx++;
			}
		}
		for(int idx = 0; idx < n; idx++) {
				arr[idx] /= M;
		}
		
//		Brute - Force approach uses O(N) space
		
//		int[] res = new int[arr.length];
//
//		res[res.length - 1] = arr[res.length / 2];
//		int one = 0, two = arr.length - 1;
//		for(int idx = 0; idx + 1 < res.length; idx+=2, one++, two--) {
//			res[idx] = arr[two];
//			res[idx + 1] = arr[one];
//		}
//		
//		for(int idx = 0; idx < arr.length; idx++) {
//			arr[idx] = res[idx];
//		}
//		return res;
	}
}
