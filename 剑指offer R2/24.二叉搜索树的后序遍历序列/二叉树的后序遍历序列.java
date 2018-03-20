public class Solution {
    public boolean VerifySquenceOfBST(int [] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return helper(arr, 0, arr.length - 1);
    }
    boolean helper(int[] arr, int left, int right) {
        if (left >= right) {
            return true;
        }
        int root = arr[right];
        int leftEnd = right - 1;
        int rightStart = arr.length;
        for (int i = left; i < right; i++) {
            if (arr[i] > root) {
                leftEnd = i - 1;
                rightStart = i;
                break;
            }
        }
        for (int i = rightStart; i <= right - 1; i++) {
            if (arr[i] < root) {
                return false;
            }
        }
        return helper(arr, left, leftEnd) && helper(arr, rightStart, right - 1);
    }
} 