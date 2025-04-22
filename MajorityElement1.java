package pack.DSA.Week3;

public class MajorityElement1 {

	public int majorityElement(int[] array) {
//		Using Moore's Law
		int count = 0, candidate = 0;
		
		for(int arr : array) {
			if(count == 0) {
				candidate = arr;
			}
			count += (arr == candidate) ? 1 : -1;
		}
		
//		For verification of frequency element
		int freq = 0;
		for(int arr : array) {
			if(arr == candidate) freq++;
		}
		
		return freq > array.length / 2 ? candidate : -1;
	}
}
