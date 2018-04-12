public class Solution {
    public boolean VerifySquenceOfBST(int [] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return helper(arr, 0, arr.length - 1);
    }
    public boolean helper(int[] arr, int left, int right) {
        if (left >= right) {
            return true;
        }
        int i = left;
        for (; i < right; i++) {
            if (arr[i] > arr[right]) {
                for (int j = i + 1; j < right; j++) {
                    if (arr[j] < arr[right]) {
                        return false;
                    }
                }
                break;
            }
        }
        return helper(arr, left, i - 1) && helper(arr, i, right - 1);
    }
}