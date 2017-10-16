class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }
        int rowS = 0;
        int colS = 0;
        int col = n - 1;
        int row = n - 1;
        int count = 1;
        int max= n * n;
        int[][] ret = new int[n][n];
        while (rowS <= row && colS <= col) {
            for (int i = colS; i <= col; i++) {
                ret[rowS][i] = count++;
            }
            rowS++;
            if (rowS <= row) {
                for (int i = rowS; i <= row; i++) {
                    ret[i][col] = count++;
                }
                col--;
            } else {
                break;
            }
            for (int i = col; i >= colS; i--) {
                ret[row][i] = count++;
            }
            row--;
            if (rowS <= row) {
                for (int i = row; i >= rowS; i--) {
                    ret[i][colS] = count++;
                }
                colS++;
            } else {
                break;
            }
        }
        return ret;
    }
}