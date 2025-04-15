package pack.Searching.BinarySearch;

public class CommonFactors {

	 public int commonFactors(int a,int b) {
	        // write your code here
	        
	        int gcd = gcd(a, b);
	        
	        return factors(gcd);
	    }
	    
	    int gcd(int a, int b){
	        return b == 0 ? a : gcd(b, a % b);
	    }
	    
	    int factors(int gcd){
	        int factor = 0;
	        
	        for(int idx = 1; idx * idx <= gcd; idx++){
	            if(gcd % idx == 0){
	                factor += (idx * idx == gcd) ? 1 : 2; // Count pairs also
	            }
	        }
	        
	        
	        return factor;
	    }
}
