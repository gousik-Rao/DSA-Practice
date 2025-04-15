package pack.DSA.Week3;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanToIntegger {

	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV"));
	}
	
	static public int romanToInt(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] ch = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int add[] = {1, 5, 10, 50, 100, 500, 1000};
        
        for(int idx = 0; idx < 7; idx++){
            map.put(ch[idx], add[idx]);
        }
        System.out.println(map);
        char[] chArr = s.toCharArray();

        int sum = 0;
        for(int idx = 0; idx + 1 < chArr.length; idx++){
            if(map.get(chArr[idx]) < map.get(chArr[idx + 1])){
                sum -= map.get(chArr[idx]);
            }else{
                sum += map.get(chArr[idx]);
            }
        }

        return sum;
    }
}
