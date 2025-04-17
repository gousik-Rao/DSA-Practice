package pack.DSA.Week3;

public class SumOfSubarrays {

	public static void main(String[] args) {
		System.out.println(subarraySum(new int[] {1, 2, 3, 4, 5}));
	}
	
	static public long subarraySum(int[] arr) {
        // code here
		if(arr.length == 1) {
			return arr[0];
		}
		
		long modulo = (int)(Math.pow(10, 9) + 7);
        long sum = 0, n = arr.length;
        
        for(int idx = 0; idx < arr.length; idx++) {
        	long element = arr[idx] % modulo;
        	long ap = (idx + 1) % modulo;
        	long bp = (n - idx) % modulo;
        	
        	long contribution = element * ap * bp;
        	
        	sum += contribution;
        }
       
        return sum;
    }
}
