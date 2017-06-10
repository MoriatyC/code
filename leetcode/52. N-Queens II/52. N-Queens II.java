public class Solution {
    public int totalNQueens(int n) {
        int[] ret = new int[1];
        boolean[] col = new boolean[2 * n];
        boolean[] d1 = new boolean[2 * n];
        boolean[] d2 = new boolean[2 * n];
        helper(ret, col, d1, d2, n, 0);
        return ret[0];
    }
    void helper(int[] ret, boolean[] col, boolean[] d1, boolean[] d2, int n, int curRow) {
        if (curRow == n) {
            ret[0]++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] || d1[i - curRow + n - 1] || d2[i + curRow]) {
                continue;
            }
            col[i] = true;
            d1[i - curRow + n - 1] = true;
            d2[i + curRow] = true;
            
            helper(ret, col, d1, d2, n, curRow + 1);
            
            col[i] = false;
            d1[i - curRow + n - 1] = false;
            d2[i + curRow] = false;
        }
    }
}