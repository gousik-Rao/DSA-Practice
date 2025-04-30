package pack.DSA.Week4;

import java.util.Arrays;

public class ReverseString {
	
	public static void main(String[] args) {
		char[] arr = {'h', 'e', 'l', 'l', 'o'};
		reverseString(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	static public void reverseString(char[] s) {
        reverse(s, 0, s.length - 1);
    }
	
    static void reverse(char[] s, int left, int right){
        if(left >= right){
            return;
        }

        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        reverse(s, ++left, --right);
    }
}
