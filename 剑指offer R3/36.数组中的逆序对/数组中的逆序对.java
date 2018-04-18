public class Solution {
    public int InversePairs(int [] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return mergeHelper(arr, 0, arr.length - 1);
    }
    public int mergeHelper(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftCount = mergeHelper(arr, left, mid) % 1000000007;
        int rightCount = mergeHelper(arr, mid + 1, right) % 1000000007;
        long ret = (leftCount + rightCount + merge(arr, left, mid, right)) % 1000000007;
        return  (int)ret;
    }
    public int merge(int[] arr, int left, int mid, int right) {
        int s1 = left;
        int s2 = mid + 1;
        int e1 = mid;
        int e2 = right;
        int[] tmp = new int[right - left + 1];
        int index = tmp.length - 1;
        long count = 0;
        while (s1 <= e1 && s2 <= e2) {
            if (arr[e2] >= arr[e1]) {
                tmp[index--] = arr[e2--];
            } else {
                count += e2 - s2 + 1;
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
        for (; left <= right; left++) {
            arr[left] = tmp[index++];
        }
        return (int)(count % 1000000007);
    }
}