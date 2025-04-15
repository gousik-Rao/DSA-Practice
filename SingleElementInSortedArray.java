package pack.Searching.BinarySearch;

public class SingleElementInSortedArray {

	public int singleNonDuplicate(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    int binarySearch(int[] arr, int start, int end){
        if(arr.length == 1){
            return arr[start];
        }
        int mid = start + (end - start) / 2;

        if(mid == 0){
            if(arr[mid] != arr[mid + 1]){
                return arr[mid];
            }else{
                return binarySearch(arr, mid + 2, end);
            }
        }else if(mid == arr.length - 1){
            if(arr[mid] != arr[mid - 1]){
                return arr[mid];
            }else{
                return binarySearch(arr, start, mid - 2);
            }
        }

        if(arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]){
            return arr[mid];
        }

        if(arr[mid] == arr[mid - 1] && mid % 2 == 0){
            return binarySearch(arr, start, mid - 2);
        }else if(arr[mid] == arr[mid - 1] && mid % 2 != 0){
            return binarySearch(arr, mid + 1, end);
        }else if(arr[mid] == arr[mid + 1] && mid % 2 == 0){
            return binarySearch(arr, mid + 1, end);
        }else {
            return binarySearch(arr, start, mid - 2);
        }
    }
}
