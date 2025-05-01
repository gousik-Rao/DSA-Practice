package pack.DSA.Week4;

public class PrintNTo1WithoutLoop {

	void printNos(int N) {
        // code here
        
        if(N <= 0){
        	return;
        }
        
        System.out.print(N + " ");
        printNos(N - 1);
    }
}
