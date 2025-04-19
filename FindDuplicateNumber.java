package pack.DSA.Week3;

public class FindDuplicateNumber {

	public static void main(String[] args) {
		System.out.println(findDuplicate(new int[] {1, 3, 4, 2, 2}));
	}
	
	static public int findDuplicate(int[] nums) {
		
		int slow = 0;
		int fast = 0;
		
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while(slow != fast);
		
		slow = 0;
		
		while(slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		
		return slow;
		
//	'Brute - Force approach'	
//        Map<Integer, Integer> map = new HashMap<>();
//        
//        for(int num : nums) {
//        	map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        
//        int result = Integer.MIN_VALUE;
//        
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
//        	if(entry.getValue() > 1)
//        		result = entry.getKey();
//        }
//        
//        return result;
    }
}
