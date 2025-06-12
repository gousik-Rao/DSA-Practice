package pack.DSA.Week5;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
	
	public int distributeCandies(int[] candies) {
        // write your code here
        Set<Integer> candySet = new HashSet<>();
        
        for(int candy : candies) {
        	candySet.add(candy);
        }
        
        int types = candySet.size();
        int maxCandyCanEat = candies.length / 2;
        
        return Math.min(maxCandyCanEat, types);
    }
}
