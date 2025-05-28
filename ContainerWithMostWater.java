package pack.DSA.Week5;

public class ContainerWithMostWater {
	
	public static void main(String[] args) {
		System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
	}
	
	static public int maxArea(int[] heights) {
		int left = 0, right = heights.length - 1;
		
		int waterAmount = 0;
		while(left < right) {
			int height = Math.min(heights[left], heights[right]);
			int width = right - left;
			int area = width * height;
			
			
			waterAmount = Math.max(waterAmount, area);
			
			if(heights[left] < heights[right]) left++;
			else right--;
		}
		return waterAmount;
	}
}
