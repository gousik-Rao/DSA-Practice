package pack.DSA.Week6;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementII {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int idx = nums2.length - 1; idx >= 0; idx--){
            if(st.isEmpty()){
                map.put(nums2[idx], -1);
                st.add(nums2[idx]);
                continue;
            }

            while(nums2[idx] > st.peek()){
                st.pop();
            }
            
            if(st.isEmpty()) {
            	map.put(nums2[idx], -1);
            }else {
            	map.put(nums2[idx], st.peek());
            }
            
            st.add(nums2[idx]);
        }
        
//        Checking with the nums1 array
        int[] res = new int[nums1.length];
        for(int idx = 0; idx < nums1.length; idx++){
            if(map.containsKey(nums1[idx])){
                res[idx] = map.get(nums1[idx]);
            }
        }

        return res;
    }
	
}
