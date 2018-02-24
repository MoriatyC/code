import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0; 
        int right = array.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (array[left] < array[right]) {
                return array[left];
            }
            if (array[mid]  > array[left]) {
                left = mid + 1;
            } else if (array[mid] < array[left]){
                right = mid;
            } else {
                return help(array, left, right);
            }
        }
        return array[left];
    }
    public int help(int[] arr, int left, int right) {
        int ret = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            ret = Math.min(ret, arr[i]);
        }
        return ret;
    }
}