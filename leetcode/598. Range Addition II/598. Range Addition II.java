public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int rowMin = 40000;
        int colMin = 40000;
        if (ops.length == 0) {
            return n * m;
        }
        for (int i = 0; i < ops.length; i++) {
            int row = ops[i][0];
            int col = ops[i][1];
            rowMin = Math.min(rowMin, row);
            colMin = Math.min(colMin, col);
        }
        return rowMin * colMin;
    }
}