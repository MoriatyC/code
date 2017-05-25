public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[len - 1][len - 1] + 1;
        int mid, i, j, count;
        while (low < high) {
            mid = low + (high - low) / 2;
            j = len - 1;
            count = 0;
            for (i = 0; i < len; i++) {
                while (j >= 0 && mid < matrix[i][j]) {
                    j--;
                }
                count += j + 1;
            }
            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}