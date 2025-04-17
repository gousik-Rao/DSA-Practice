package pack.DSA.Week3;

public class MaxChunks {

	public int maxChunksToSorted(int[] arr) {

        int count = 0, currentMax = -1; 
        for(int idx = 0; idx < arr.length; ){
            if(currentMax < arr[idx]){
                currentMax = arr[idx];
            }

            if(currentMax == idx){
                count++;
                idx++;
            }
            else{
                idx++;
            }
        }
        return count;
    }
}
