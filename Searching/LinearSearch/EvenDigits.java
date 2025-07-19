package pack.DSA.Week2.Searching.LinearSearch;

public class EvenDigits {

	public static void main(String[] args) {
		int[] nums = {12, 345, 2, 6, 7896};
		System.out.println(findNumbers(nums));
		
		System.out.println(digits2(-19404));
	}
	
	static int findNumbers(int[] arr) {
		int count = 0;
		for(int idx : arr) {
			if(even(idx)) {
				count++;
			}
		}
		return count;
	}
	
	static boolean even(int num) {
		int noOfDigits = digits(num);
		
		return noOfDigits % 2 == 0; 
	}
	
	static int digits(int num) {
		if(num < 0) {
			num *= -1;
		}
		if(num == 0) return 1;
		
		int count = 0;
		while(num > 0) {
			count ++;
			num /= 10;
		}
		return count;
	}
	
	static int digits2(int num) {
		if(num < 0) {
			num *= -1;
		}
		if(num == 0) return 1;
		return (int)Math.log10(num) + 1;
	}
}






