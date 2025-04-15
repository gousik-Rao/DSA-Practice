package pack.DSA.Week3;

import java.util.Arrays;

public class WaveArray {

	public static void main(String[] args) {
		int[] array = new int[] {1,2,3,4,5};
		convertToWave(array);
		System.out.println(Arrays.toString(array));
	}

    public static void convertToWave(int[] arr) {
        // code here

        for(int idx = 0; idx + 1 < arr.length; idx += 2){
            swap(arr, idx, idx + 1);
        }
    }
    
    static void swap(int[] arr, int one, int two){
        int temp = arr[one];
         arr[one] = arr[two];
         arr[two] = temp;
    }

}
