package pack.DSA.Week3;

import java.util.Arrays;

public class MissingElement {

	public static void main(String[] args) {
		MissingElement ms = new MissingElement();
		
		System.out.println(ms.missingNumber(new int[] {3, 2, 4, 1}));
	}
	
	int missingNumber(int arr[]) {
        // code here
        int n = arr.length; // or arr.length + 1 (To find the missing element)
        
        if(arr[0] == 1 && n == 1){
            return arr[0] + 1;
        }
        
        int max = Arrays.stream(arr).max().getAsInt();
        
        long expSum = (max * (max + 1L)) / 2;
        int actualSum = 0;
        
        for(int idx = 0; idx < n; idx++){
            actualSum += arr[idx];
        }
        return expSum - actualSum == 0 ? (int)(max + 1) : (int) (expSum - actualSum);              
    }
}
