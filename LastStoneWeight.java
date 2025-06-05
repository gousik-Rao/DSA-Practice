package pack.DSA.Week6;

import java.util.Collections;
import java.util.Queue;
import java.util.PriorityQueue;

public class LastStoneWeight {

	public static void main(String[] args) {
		System.out.println(lastStoneWeight(new int [] {2, 7, 4, 1, 8, 1,}));
	}
	
	static public int lastStoneWeight(int[] stones) {
		Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());                        
		
		for(int stone : stones) {
			maxHeap.add(stone);
		}
		
		System.out.println(maxHeap);
		
		int size = maxHeap.size();
		while(size > 1) {
			int one = maxHeap.poll();
			int two = maxHeap.poll();
			
			if(one != two) {
				maxHeap.add(one - two);
				size -= 1;
			}
			else size -= 2;
		}
		return maxHeap.isEmpty() ? 0 : maxHeap.peek();
	}
}
