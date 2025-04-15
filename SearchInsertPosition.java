package pack.Searching.BinarySearch;

public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        
        return binarySearch(nums, target, start, end);
    }

    int binarySearch(int[] nums, int target, int start, int end){
        int mid = start + (end - start) / 2;
        if(start > end){
            return mid;
        }

        if(target == nums[mid]){
            return mid;
        }
        else if(target < nums[mid]){
            return binarySearch(nums, target, start, mid - 1);
        }else{
            return binarySearch(nums, target, mid + 1, end);
        }
    }
}
