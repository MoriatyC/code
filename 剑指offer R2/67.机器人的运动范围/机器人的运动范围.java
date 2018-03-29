public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        if (rows <= 0 || cols <= 0 || threshold < 0) {
            return 0;
        }
        boolean[][] used = new boolean[rows][cols];
        return backtracking(threshold, rows, cols, 0, 0, used);
    }
    public int backtracking(int threshold, int rows, int cols, int row, int col, boolean[][] used) {
        int ret = 0;
        if (row >= 0 && row < rows && col < cols && col >= 0 && !used[row][col] && check(threshold, row, col)) {
            ret++;
            used[row][col] = true;
            ret += backtracking(threshold, rows, cols, row + 1, col, used);
            ret += backtracking(threshold, rows, cols, row - 1, col, used);
            ret += backtracking(threshold, rows, cols, row, col + 1, used);
            ret += backtracking(threshold, rows, cols, row, col - 1, used);
        }
        return ret;
    }
    public boolean check(int thredhold, int row, int col) {
        int count = 0;
        while (row > 0) {
            count += row % 10;
            row /= 10;
        }
        while (col > 0) {
            count += col % 10;
            col /= 10;
        }
        return thredhold >= count;
    }
}