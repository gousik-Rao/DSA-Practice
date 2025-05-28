package pack.DSA.Week5;

public class FindDuplicatesFromWeek3 {

	public int findDuplicateLinkedListTrick(int[] nums) {
		int slow = 0, fast = 0;
		
		do { // Do the 2 pointers one moves slowly pointing the next index,
//			The other points to the next's next value.
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while(slow != fast);
		
//		Set one value to the start
		slow = 0;
		
		while(slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		
//		This now contains the duplicate value as the cycle will be met at a certain point                    
		return slow;
	}
	
	public int findDuplicateBinarySearchTrick(int[] nums) {
		
		int start = 1, end = nums.length - 1;
		
		while(start < end) {
			int mid = start + ((end - start) >> 1);
			int count = 0;
			for(int num : nums) {
				if(num < mid) count++;
			}
			
			if(count > mid) end = mid;
			else start = mid + 1;
		}
		
		return end;
	}
	
	public int findDuplicateBitManipulateTrick(int[] nums) {
		int n = nums.length - 1, duplicate = 0;
		
		for(int bit = 0; bit < 32; bit++) {
			int mask = (1 << bit);
			int baseCount = 0, numsCount = 0;
			
			for(int idx = 1; idx <= n; idx++) {
				if((idx & mask) != 0) baseCount++;
			}
			
			for(int num : nums) {
				if((num & mask) != 0) numsCount++;
			}
			
			if(numsCount > baseCount) duplicate |= mask;;
		}
		
		return duplicate;
	}
}
















