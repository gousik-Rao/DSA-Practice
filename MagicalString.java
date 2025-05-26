package pack.DSA.Week5;

public class MagicalString {

	public static void main(String[] args) {
		System.out.println(magicalStrings(6));
	}
	
	static public int magicalStrings(int n) {
		int onesCount = 1;
		int write = 3, num = 1;
		int read = 2;
		
		int[] magic = new int[n + 2]; // For buffer
		magic[0] = 1; magic[1] = 2; magic[2] = 2;
		
		while(write < n) {
			int freq = magic[read];
			for(int idx = 0; idx < freq && write < n; idx++) {
				magic[write] = num;
				if(num == 1) onesCount++;
				write++;
			}
			
			num = 3 - num;
			read++;
		}
		
		return onesCount;
	}
	
//	Inefficient
	static public int magicalString(int n) {
		int onesCount = 0;
		boolean numberCond = true;
		int index = 2;
		StringBuilder str = new StringBuilder("122");
		
		while(str.length() < n) {
//			Append number 1
			if(numberCond) {
				for(int idx = 0; idx < Integer.parseInt(str.charAt(index) + ""); idx++) {
					str.append(1);
				}
				numberCond = false;
			}else {
//				Append number 2
				for(int idx = 0; idx < Integer.parseInt(str.charAt(index) + ""); idx++) {                                 
					str.append(2);
				}
				numberCond = true;
			}
			index++;
		}
		
		for(int idx = 0; idx < str.length(); idx++) {
			if(str.charAt(idx) == '1') onesCount++;
		}
		
		System.out.println(str);
		return onesCount;
	}
}
