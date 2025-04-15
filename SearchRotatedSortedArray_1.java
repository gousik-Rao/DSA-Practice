package pack.Searching.BinarySearch;

public class SearchRotatedSortedArray_1 {

	public boolean search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    boolean binarySearch(int[] nums, int target, int start, int end){
        if(start > end)
            return false;
        int mid = start + (end - start) / 2;
        if(target == nums[mid]){
            return true;
        }

        // Handling duplicates
        if(nums[start] == nums[mid] && nums[mid] == nums[end]){
            return binarySearch(nums, target, start + 1, end - 1);
        }

        // Checking the left side is sorted or not.
        if(nums[start] <= nums[mid]){
            // if target is in left side then check left or check in right 
            if(target >= nums[start] && target < nums[mid]){
                return binarySearch(nums, target, start, mid - 1);
            }
            return binarySearch(nums, target, mid + 1, end);
        }else{ // If left is not sorted then check the right side.
            // if target is in right side then check right or check in left 
            if(target <= nums[end] && target > nums[mid]){
                return binarySearch(nums, target, mid + 1, end);
            }
            return binarySearch(nums, target, start, mid - 1);
        }
        // return false;
    }
}
