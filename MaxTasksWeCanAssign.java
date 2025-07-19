package pack.DSA.Week6;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxTasksWeCanAssign {

	static public int maxTasksAssign(int[] tasks, int[] workers, int pills, int strength) {
		int maxTasks = 0;
		int n = tasks.length, m = workers.length;
		
		Arrays.sort(workers); // Sorting workers in ascending order
		Arrays.sort(tasks);
		
		int low = 0, high = Math.min(m, n);
		while(low <= high) {
			int mid = low + (high - low) / 2;
			
			if(canDoTask(tasks, workers, pills, strength, mid)) {
				maxTasks = mid; // mid is possible
				low = mid + 1;
			}else
				high = mid - 1; // mid is too big -> reduce
		}
				
		return maxTasks;
	}
	
	private static boolean canDoTask(int[] tasks, int[] workers, int pills, int strength, int midValue) {                
		Deque<Integer> deq = new ArrayDeque<>();
		int m = workers.length;
		int task = 0;
		
		for(int idx = m - midValue; idx < m; idx++) {
			int worker = workers[idx];
			System.out.println("Worker: " + worker + ", IDX: " + idx);
			
			// Checking how many tasks the worker can do with a pill
			// If the worker's strength > the task value, then add it to the deque
			while(task < midValue && worker + strength >= tasks[task]) {
				deq.offerLast(tasks[task]);
				task += 1;
			}
//			System.out.println(deq);
			
			if(deq.isEmpty()) return false; // Check if deque is empty.
			
			// Checking whether the worker can do the easiest task without pill
			// If yes then remove the task from the fron of the deque
			if(worker >= deq.peekFirst()) {
				deq.removeFirst();
			}else {
				if(pills > 0) { // Else checking whether we have pills, if we have then remove the hardest task by consuming one pill             
					pills -= 1;
					deq.removeLast();
				}else // Or if we don't have enough pill, and the worker strength is less than the task value, nothing to do false !!
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(maxTasksAssign(
				new int[] {2, 3, 1},
				new int[] {3, 3, 0}, 1, 1
			));
	}
}
