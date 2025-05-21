package pack.DSA.Week5;

public class PairWithGivenSum {

	int countPairs(int arr[], int target) {
        // Complete the function
        int start = 0, end = arr.length - 1;
        int count = 0;
        
        while(start < end){

            int sum = arr[end] + arr[start];
            
            if(sum == target){
                if(arr[start] == arr[end]){
                    int freq = end - start + 1;
                    count += (freq * (freq - 1)) / 2;
                
                    // As count has been found return or break
                    break;
                }
                int left = 1;
                int right = 1;
                
                // Counting the left side for duplicates
                while(start + 1 < end && arr[start] == arr[start + 1]){
                    left++;
                    start++;
                }
                
                // Counting the right side for duplicates
                while(end - 1 > start && arr[end] == arr[end - 1]){
                    right++;
                    end--;
                }
                
                count += left * right;
                start++; end--;
            }else if(sum < target) start++;
            else end--;
        }
        
        return count;
    }
}
