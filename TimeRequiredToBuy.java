package pack.DSA.Week6;

import java.util.LinkedList;
import java.util.Queue;

public class TimeRequiredToBuy {

	public static void main(String[] args) {
		System.out.println(timeRequiredToBuy(new int[] {2, 3, 2,}, 2));
	}
	
	static public int timeRequiredToBuy(int[] tickets, int k) {
		Queue<Person> line = new LinkedList<>();
		int time = 0;
		
		for(int idx = 0; idx < tickets.length; idx++) {
			line.offer(new Person(tickets[idx], idx));
		}
		
		while(!line.isEmpty()) {
			Person current = line.poll();
			current.ticket -= 1;
			time += 1;
			
			if(current.index == k && current.ticket == 0) return time;
			
			if(current.ticket > 0) {
				line.offer(current);
			}
			
		}
		
		return -1;
	}
	
	static class Person{ 
		int ticket, index; 
		
		public Person(int ticket, int index) {
			this.ticket = ticket;
			this.index = index;
		}
	}
}
