package pack.Searching.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BinarySearch {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int[] array = {18, 2, 7};
		
//		int target = -0;
//		System.out.println(binarySearch(array, target));
//		
//		System.out.println(-2147483648);
//		System.out.println(-(-21474836));
		
//		System.out.println(findDuplicates(array));
//		System.out.println(findDuplicates(new int[]{4,3,2,7,8,2,3,1})); // Should print [2,3]
//		System.out.println(findDuplicates(new int[]{1,1,1})); // Should print [1]
//		System.out.println(findDuplicates(new int[]{1})); // Should print []
		
//		System.out.println(Arrays.toString(topKFrequent(new int[]{4,3,2,7,8,2,3,1}, 2)));
//		System.out.println(topKFrequent(array, 1));
		
//		System.out.println(maxSum(array, 2, 0, 1));
		
//		System.out.println(maximumSumSubarray(array, 2));
		
//		System.out.println(aggressiveCows(array, 3));
		
		System.out.println(nthUglyNumber(5, 2, 11, 13));
	}
	
	static public int nthUglyNumber(int n, int a, int b, int c) {
        List<Integer> uglyNumbers = new ArrayList<>();
        for(int idx = 2; idx < a + b + c ;idx++){
            if(idx % a == 0 || idx % b == 0 ||
                idx % c == 0){
                    uglyNumbers.add(idx);
                }
        }

        return uglyNumbers.get(n - 1);
    }
	
	static int aggressiveCows(int[] stalls, int cows) {		
//		Time complexity for sorting O(n log n)
		Arrays.sort(stalls); // [0, 27, 38, 39, 70, 89, 100]
		
		int low = 0, high = stalls[stalls.length - 1] - stalls[0];
		
		System.out.println(Arrays.toString(stalls));
		while(low <= high) {
			int mid = low + (high - low) / 2;
			
			if(canWePlaceCowHere(stalls, mid, cows)) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		
//		Returning high, because ate the start low will be in possible polarity and high will be in not possible polarity
//		But at the end the polarities will be switched so high will point to the required value
		return high;
	}
	private static boolean canWePlaceCowHere(int[] stalls, int dist, int cows) {
		int countCows = 1, last = stalls[0];
		for(int idx = 1; idx < stalls.length; idx++) {
			if(stalls[idx] - last >= dist) {
				countCows++;
				last = stalls[idx];
			}
			
			if(countCows >= cows) return true;
		}
		return false;
	}

	static public int maximumSumSubarray(int[] arr, int k) {
        // Code here
        if(arr.length == 1){
            return arr[0];
        }
        int maxSum = 0;
        for(int idx = 0; idx < k; idx++){
            maxSum += arr[idx];
        }
        int currentSum = maxSum;
        for(int idx = 0; idx <= arr.length - 1 - k; idx++){
            currentSum = arr[idx + k] + currentSum - arr[idx];
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
            System.out.println("Max: " + maxSum);
        }
        return maxSum;
    }
	
	static int maxSum(int[] arr, int k, int max, int count){
		if(k <= 0){
            return max;
        }
        
        max += arr[arr.length - count++];
        k--;
        return maxSum(arr, k, max, count);
	}
	
//	Return the index
//	return -1 if target is not found
	static int binarySearch(int[] arr, int target) {
		int start = 0, end = arr.length - 1;
		
		while(start <= end) {
//			int mid = (start + end) / 2; // At a certain point, start + end may exceed the int range                  
//			So we can use following formula, which is the same representation of the above'
			int mid = start + (end - start) / 2;
			if(arr[mid] == target) {
				return mid;
			}
			else if(target > arr[mid]) {
				start = mid + 1;
			}
			else if(target < arr[mid]) {
				end = mid - 1;
			}
		}
		return -1;
	}
	
	public static List<Integer> findDuplicates(int[] arr) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int idx = 0; idx < arr.length; idx++){
        	if(map.containsKey(arr[idx])) {
        		map.put(arr[idx], map.get(arr[idx]) + 1);
        	}else {
        		map.put(arr[idx], 1);
        	}
        }
                
        List<Integer> res = new ArrayList<>();
        for(Entry<Integer, Integer> elem : map.entrySet()) {
        	if(elem.getValue() > 1) {
        		res.add(elem.getKey());
        	}
        }
        return res;
    }
	
	static public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int array : nums){
            map.put(array, map.getOrDefault(array, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> elem = new ArrayList<>(map.entrySet());
        elem.sort((a, b) -> b.getValue().compareTo(a.getValue()));
       
        int[] resultArr = new int[k];
        
        for(int idx = 0; idx < k; idx++) {
        	resultArr[idx] = elem.get(idx).getKey();
        }
        
        return resultArr;
    }
}











