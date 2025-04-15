package pack.Searching.BinarySearch;

public class AgnosticBS {

	public static void main(String[] args) {
		int[] array = {-99, -59, -28, -10, -2, -0, 0, 27, 38, 39, 70, 89, 99};
		int[] arr = {99, 88, 77, 66, 34, 10, 0, -10, -13, -19};
		int target = 99;
		System.out.println(orderAgnosticBS(array, target));
		System.out.println(orderAgnosticBS(arr, target));
	}
 	
	static int orderAgnosticBS(int[] arr, int target) {
		int start = 0, end = arr.length - 1;
		
//		Find whether the array is ordered in ascending or descending orders
		boolean isAsc = arr[start] < arr[end];
		
		while(start <= end) {
//			int mid = (start + end) / 2; // At a certain point, start + end may exceed the int range                  
//			So we can use following formula, which is the same representation of the above'
			int mid = start + (end - start) / 2;
			
			if(arr[mid] == target) {
				return mid;
			}
			
			if(isAsc) {
				if(target > arr[mid]) {
					start = mid + 1;
				}else{
					end = mid - 1;
				}	
			}
			else {
				if(target < arr[mid]) {
					start = mid + 1;
				}else {
					end = mid - 1;
				}		
			}
		}
		return -1;
	}
}
