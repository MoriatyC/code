public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (matrix == null || matrix.length == 0 || str == null || str.length == 0 || rows <= 0 || cols <= 0) {
            return false;
        }
        boolean[][] used = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, str, 0, i, j, used)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char[] matrix, int rows, int cols, char[] str, int index, int row, int col, boolean[][] used) {
        boolean ret = false;
        if (row >=0 && row < rows && col >= 0 && col < cols && !used[row][col] && str[index] == matrix[row * cols + col]) {
                used[row][col] = true;
                index++;
                if (index == str.length) {
                    ret = true;
                } else {
                    ret = helper(matrix, rows, cols, str, index, row, col + 1, used) || helper(matrix, rows, cols, str, index, row + 1, col, used) ||
                            helper(matrix, rows, cols, str, index, row, col - 1, used) || helper(matrix, rows, cols, str, index, row - 1, col, used);
                            used[row][col] = false;
                }
                
        }
        return ret;
    }
}

    