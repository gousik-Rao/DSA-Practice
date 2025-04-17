package pack.DSA.Week3;

public class AdditionOfSubMatrix {

//	This is not optimal, as we can optimize it using "Prefix-Sum way
	long subMatrixSum(int arr[][], int n, int m, int x1, int y1, int x2, int y2) {
        // code here
        long sum = 0;
        for(int idx = x1 - 1; idx <= x2 - 1; idx++){
            for(int jdx = y1 - 1; jdx <= y2 - 1; jdx++){
                sum += arr[idx][jdx];
            }
        }
        
        return sum;
    }
}
