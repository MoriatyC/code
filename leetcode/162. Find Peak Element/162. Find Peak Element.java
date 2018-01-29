class Solution {
    public int findPeakElement(int[] A) {
        if (A == null) {
            return 0;
        }
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] > A[mid + 1]) {
                if (mid > 0 && A[mid - 1] < A[mid]) {
                    return mid;
                }
                right = mid;
            } else {
                left = mid;
            }
        }
        return A[right] > A[left] ? right : left;
    }
}