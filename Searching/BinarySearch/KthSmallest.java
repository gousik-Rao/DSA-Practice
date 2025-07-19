package pack.DSA.Week2.Searching.BinarySearch;

import java.util.PriorityQueue;

public class KthSmallest {

	public static void main(String[] args) {
		System.out.println(kthSmallest(new int[] {7, 10, 4, 3, 20, 15}, 3));
	}
	
	public static int kthSmallest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int idx = 0; idx < arr.length; idx++) {
        	minHeap.offer(arr[idx]);
        }
        
        System.out.println(minHeap);
        
        for(int idx = 1; idx < k; idx++) {
        	minHeap.poll();
        }
        
        System.out.println(minHeap);
        
        return minHeap.peek();
    }
}
