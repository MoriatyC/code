public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (matrix == null || matrix.length == 0 || str == null || str.length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, str, visited, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char[] matrix, int rows, int cols, char[] str, boolean[][] visited, int index, int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col] && matrix[row * cols + col] == str[index]) {
            if (index == str.length - 1) {
                return true;
            }
            visited[row][col] = true;
            boolean tmp = helper(matrix, rows, cols, str, visited, index + 1, row - 1, col)
                    || helper(matrix, rows, cols, str, visited, index + 1, row + 1, col)
                    || helper(matrix, rows, cols, str, visited, index + 1, row, col - 1)
                    || helper(matrix, rows, cols, str, visited, index + 1, row, col + 1);
            visited[row][col] = false;
            return tmp;
        }
        return false;
    }


}