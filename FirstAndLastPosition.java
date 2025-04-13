package pack.Searching.BinarySearch;

public class FirstAndLastPosition {

	public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int[] res = new int[2];
        res[0] = firstOcc(nums, target, start, end, -1);
        res[1] = lastOcc(nums, target, start, end, -1);

        if(res[0] != -1 && res[1] == -1)
            res[1] = res[0];
        else if(res[1] != -1 && res[0] == -1)
            res[0] =res[1];
        return res;
    }


    int firstOcc(int[] arr, int target, int start, int end, int res){
        // Base condition
        if(start > end)
            return res;
        int mid = start + (end - start) / 2;

        if(arr[mid] == target){
            res = mid;
            return firstOcc(arr, target, start, mid - 1, res);
        } else if(target < arr[mid]){
            return firstOcc(arr, target, start, mid - 1, res);
        }else{
            return firstOcc(arr, target, mid + 1, end, res);
        }
    }

    int lastOcc(int[] arr, int target, int start, int end, int res){
        if(start > end)
            return res;
        int mid = start + (end - start) / 2;

        if(arr[mid] == target){
            res = mid;
            return lastOcc(arr, target, mid + 1, end, res);
        } else if(target > arr[mid]){
            return lastOcc(arr, target, mid + 1, end, res);
        } else{
            return lastOcc(arr, target, start, mid - 1, res);
        }
    }
}






