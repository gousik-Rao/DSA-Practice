package pack.Searching.BinarySearch;

public class PeakElement {

	public int findPeakElement(int[] nums) {
        return searchingPeak(nums, 0, nums.length - 1);
    }

    int searchingPeak(int[] nums, int start, int end){
        // For single element array
        if(nums.length == 1)
            return start;
        
        // if(start == end)
        //     return nums[start] > nums[end] ? start : end;

        int mid = start + (end - start) / 2;

        // Boundary checks
        if(mid == 0){
            return nums[mid] < nums[mid + 1] ? mid + 1 : mid;
        }else if(mid == nums.length - 1){
            return nums[mid] < nums[mid - 1] ? mid - 1 : mid;
        }
        
        // Intermediate checks
        if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
            return mid;
        }

        // If adjacent elem is greater move that side.
        if(nums[mid + 1] > nums[mid]){
            return searchingPeak(nums, mid + 1, end);
        }else{
            return searchingPeak(nums, start, mid);
        }
    }
}
