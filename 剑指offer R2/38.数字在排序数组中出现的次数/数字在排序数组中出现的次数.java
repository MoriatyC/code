public class Solution {
    public int GetNumberOfK(int [] array , int k) {
       if (array == null || array.length == 0) {
           return 0;
       }
       int last = getLast(array, 0, array.length - 1, k);
       int first = getFirst(array, 0, array.length - 1, k);
       return last != -1 ? last - first + 1 : 0;
    }
    public int getFirst(int[] arr, int left, int right, int k) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (arr[left] == k) {
            return left;
        }
        return -1;
    }
    public int getLast(int[] arr, int left, int right, int k) {
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid] <= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (arr[left] == k) {
            return left;
        }
        return -1;
    }
}