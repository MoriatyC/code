class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        int n = matrix.length;
        for (int i = 0;  i <= n - 2; i++) {
            int j = n - 1;
            for (int k = 0; k + i < n - 1; k++) {
                swapNumber(matrix, i, k, j--, n - 1 - i);
            }
        }
        int top = 0;
        int down = n - 1;
        while (top < down) {
            for (int i = 0; i < n; i++) {
                swapNumber(matrix, top, i, down, i);
            }
            top++;
            down--;
        }
    }

    public void swapNumber(int[][] arr, int i1, int i2, int j1, int j2) {
        int tmp = arr[i1][i2];
        arr[i1][i2] = arr[j1][j2];
        arr[j1][j2] = tmp;
    }
}