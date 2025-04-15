package pack.Searching.BinarySearch;

public class SearchRotatedSortedArray_2 {

	public int findMin(int[] nums) {
        return binarySearch(nums, Integer.MAX_VALUE, 0, nums.length - 1);
    }

    int binarySearch(int[] nums, int min, int start, int end){
        if(start > end){
            return min;
        }

        int mid = start +(end - start) / 2;
        // Tracking the minimum value
        min = Math.min(min, nums[mid]);

        // Eliminating duplicates
        if(nums[start] == nums[mid] && nums[mid] == nums[end]){
            return binarySearch(nums, min, start + 1, end - 1);
        }
        
        // Check the left side if it is sorted, then assign the start value to min and
        // Check the right side and compare that with the min for the actual minimum value.
        if(nums[start] <= nums[mid]){
            if(nums[start] < min){
                min = nums[start];
                return Math.min(min, binarySearch(nums, min, mid + 1, end));
            }else{
                return binarySearch(nums, min, mid + 1, end);
            }
        }else{ // The opposite is for this else part
            if(nums[mid] < min){
                min = nums[mid];
                return Math.min(min, binarySearch(nums, min, start, mid - 1));
            }
            return binarySearch(nums, min, start, mid - 1);
        }
    }
}
