public class Solution {
    long ret = 0;
    public int InversePairs(int [] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        helper(arr, 0, arr.length - 1);
        return (int)ret;
    }
    public void helper(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + ((end - start) >> 1);
        helper(arr, start, mid);
        helper(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }
    public void merge(int[] arr, int left, int mid, int right) {
        int s1 = left;
        int s2 = mid + 1;
        int e1 = mid;
        int e2 = right;
        int[] tmp = new int[right - left + 1];
        int index = tmp.length - 1;
        while (s1 <= e1 && s2 <= e2) {
            if (arr[e1] <= arr[e2]) {
                tmp[index--] = arr[e2--];
            } else {
                ret += e2 - s2 + 1;
                ret %= 1000000007;
                tmp[index--] = arr[e1--];
            }
        }
        while (s1 <= e1) {
            tmp[index--] = arr[e1--];
        }
        while (s2 <= e2) {
            tmp[index--] = arr[e2--];
        }
        index = 0;
        for (int i = left; i <= right; i++) {
            arr[i] = tmp[index++];
        }
    }
}