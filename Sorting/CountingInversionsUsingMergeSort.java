package pack.DSA.Week2.Sorting;

public class CountingInversionsUsingMergeSort {

	public static void main(String[] args) {
		System.out.println(inversionCount(new int[] {2, 4, 1, 3, 5}));
	}
	
	// Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        return countInversions(arr, 0, arr.length);
    }

	private static int countInversions(int[] arr, int start, int end) {                    
		if(end - start <= 1) return 0;
		
		int mid = start + ((end - start) >> 1);
		
		int left = countInversions(arr,start, mid);
		int right = countInversions(arr, mid, end);
		
		int result = crossCounts(arr, start, mid, end);
		
		return result + left + right;
	}

	// In - Place merging
	private static int crossCounts(int[] arr, int start, int mid, int end) {
		int idx = start, jdx = mid, kdx = 0;
		int[] res = new int[end - start];
		int count = 0;
		while(idx < mid && jdx < end) {
			if(arr[idx] > arr[jdx]) {
				res[kdx++] = arr[jdx++];
				count += mid - idx; // Important line as the elements from idx to mid will be inversed 
									// if the condition is true As the array is sorted!!
			}else {
				res[kdx++] = arr[idx++];
			}
		}
		
		while(idx < mid) {
			res[kdx++] = arr[idx++];
		}
		
		while(jdx < end) {
			res[kdx++] = arr[jdx++];
		}
		
		// Deep copy of array
		for(int index = 0; index < res.length; index++) {
			arr[index + start] = res[index];
		}
		
		return count;
	}
}












