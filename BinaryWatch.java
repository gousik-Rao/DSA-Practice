package pack.DSA.Week4;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

	public static void main(String[] args) {
		System.out.println(readBinaryWatch(1));
	}
	
	static public List<String> readBinaryWatch(int turnedOn){
		List<String> res = new ArrayList<>();
		
		backtrack(turnedOn, 0, 0, 0, res);
		
		return res;
	}
	
	static private void backtrack(int turnedOn, int start, int hour, int minute, List<String> res) {                
		if(turnedOn <= 0) {
			if(hour < 12 && minute < 60) {
				res.add(String.format("%d:%02d", hour, minute));
			}
			return;
		}
		
		for(int bit = start; bit < 10; bit++) {
			int newHour = hour, newMinute = minute;
			
			if(bit < 4) newHour += 1 << bit; // Hour bits (0 - 3)
			else newMinute += 1 << (bit - 4); // Minute bits (4 - 9)
			
			System.out.printf("bit = %d hour = %d minute = %d\n", bit, newHour, newMinute);
			
			backtrack(turnedOn - 1, bit + 1, newHour, newMinute, res); // Move to next bit       
		}
	}
}













