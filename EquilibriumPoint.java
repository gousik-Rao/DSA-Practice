package pack.DSA.Week3;

public class EquilibriumPoint {

	public static void main(String[] args) {
		System.out.println(findEquilibrium(new int[] {-7, 1, 5, 2, -4, 3, 0}));
	}
	
	 public static int findEquilibrium(int arr[]) {
	        // code here
	        if(arr.length <= 2){
	            return -1;
	        }
	        
	        int totalSum = 0;
	        for(int a : arr) {
	        	totalSum += a;
	        }
	        System.out.println("Total sum: " + totalSum);
	        
	        int leftSum = 0;
	        for(int idx = 1; idx < arr.length - 1; idx++){
	            leftSum = leftSum + arr[idx - 1];
	            int rightSum = totalSum - leftSum - arr[idx];
	            
	            System.out.println(leftSum + " " + rightSum);
	            
	            if(leftSum == rightSum) {
	            	return idx;
	            }
	        }
	        return -1;
	    }

}
