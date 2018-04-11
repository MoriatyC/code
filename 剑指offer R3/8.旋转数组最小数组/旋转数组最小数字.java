import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] < array[right]) {
                return array[left];
            }
            int mid = left + (right - left) / 2;//向下取中点
            if (array[mid] == array[right]) {
                right--;
            } else {
                if (array[mid] >= array[left]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return array[left];
    }
}