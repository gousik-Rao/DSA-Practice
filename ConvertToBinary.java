package pack.DSA.Week4;

public class ConvertToBinary {
	
	public String baseNeg2(int n) {
		if(n == 0) return "0";
		
        StringBuilder result = new StringBuilder();
        while(n >= 1){
        	int remainder = n % -2;
        	
        	if(remainder < 0) {
        		remainder += 2;
        		n = (n / 2) + 1;
        	}else
        		n /= -2;

//            n = n >> 1; // Instead of n / 2
        }

        return result.reverse().toString();
    }
}
