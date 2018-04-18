public class Solution {
    public int GetNumberOfK(int [] array , int k) {
       if (array == null || array.length == 0) {
           return 0;
       }
       int first = getFirst(array, k);
       if (first == -1) {
           return 0;
       }
       int last = getLast(array, k);
       return last - first + 1;
    }
    public int getFirst(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (arr[left] == k) {
            return left;
        } 
        return -1;
    }
    public int getLast(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (arr[mid] > k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}