public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        if (threshold <= 0) {
            return 0;
        }
        int[] ret = {0};
        boolean[][] visited = new boolean[rows][cols];
        backstracking(0, 0, rows, cols, ret, visited, threshold);
        return ret[0];
    }
    public void backstracking(int row, int col, int rows, int cols, int[] ret, boolean[][] visited, int threshold) {
        if (row >=0 && row < rows && col >= 0 && col < cols && helper(threshold, row, col) && !visited[row][col]) {
            ret[0]++;
            visited[row][col] = true;
            backstracking(row + 1, col, rows, cols, ret, visited, threshold);
            backstracking(row - 1, col, rows, cols, ret, visited, threshold);
            backstracking(row, col + 1, rows, cols, ret, visited, threshold);
            backstracking(row, col - 1, rows, cols, ret, visited, threshold);
        } 
    }
    public boolean helper(int threshold, int row, int col) {
        int sum = 0;
        while (row > 0) {
            sum += row % 10;
            row /= 10;
        }
        while (col > 0) {
            sum += col % 10;
            col /= 10;
        }
        return sum <= threshold;
    }
}