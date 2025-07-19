package pack.DSA.Week2.Searching.BinarySearch;

public class SingleElementInSortedArray {

	public static void main(String[] args) {
		System.out.println(singleNonDuplicate(new int[] {5, 5, 6, 6, 4, 3, 3, 1, 1, 9, 9}));
	}
	
	static public int singleNonDuplicate(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    static int search(int[] nums, int start, int end){
    	if(nums.length == 1){
            return nums[start];
        }
        int mid = start + ((end - start) >> 1);

        if(mid == 0){
            if(nums[mid] != nums[mid + 1]){
                return nums[mid];
            }else{
                return search(nums, mid + 2, end);
            }
        }else if(mid == nums.length - 1){
            if(nums[mid] != nums[mid - 1]){
                return nums[mid];
            }else{
                return search(nums, start, mid - 2);
            }
        }

//      if mid element is the single element
        if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
        	return nums[mid];
        }
        
//      Moving left condition
        if(nums[mid] == nums[mid - 1] && mid % 2 == 0 || 
        		(nums[mid] == nums[mid + 1]) && mid % 2 != 0) {
        	return search(nums, start, mid - 2);
        }
        
//      Else move right
        else {
        	return search(nums, mid + 1, start);
        }
    }
}
