public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        int row = 0;
        int col = 0;
        int[] ret = {0};
        backtracking(col, row, cols, rows, threshold, visited, ret);
        return ret[0];
    }
    public void backtracking(int col, int row, int cols, int rows, int threshold, boolean[][] visited, int[] ret) {
        if (col < 0 || row < 0 || col >= cols || row >= rows || visited[row][col]) {
            return;
        }
        if (canPass(col, row, threshold)) {
            visited[row][col] = true;
            ret[0]++;
            backtracking(col, row + 1, cols, rows, threshold, visited, ret);
            backtracking(col, row - 1, cols, rows, threshold, visited, ret);
            backtracking(col + 1, row, cols, rows, threshold, visited, ret);
            backtracking(col - 1, row, cols, rows, threshold, visited, ret);
        }
    }
    public boolean canPass(int col, int row, int threshold) {
        int sum = 0;
        while (col > 0) {
            sum += col % 10;
            if (sum > threshold) {
                return false;
            }
            col /= 10;
        }
        while (row > 0) {
            sum += row % 10;
            if (sum > threshold) {
                return false;
            }
            row /= 10;
        }
        return true;
    }
}