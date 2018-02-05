public class Solution {
    /*
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int left = 0;
        int right = A.length - 1;
        while (left != right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                if (A[mid] > A[left] && A[mid] > A[right]) {
                    left = mid + 1;
                } else if (A[mid] > A[left] && A[mid] < A[right]) {
                    left = mid + 1;
                } else if (A[mid] < A[left] && A[mid] < A[right]) {
                    if (target > A[right]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            } else {
                if (A[mid] > A[left] && A[mid] > A[right]) {
                    if (target < A[left]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else if (A[mid] > A[left] && A[mid] < A[right]) {
                    right = mid - 1;
                } else if (A[mid] < A[left] && A[mid] < A[right]) {
                    right = mid - 1;
                }
            }
        }
         if (A[left] == target) {
                return left;
            }
            return -1;
    }
}