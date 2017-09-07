class Solution {
    public int[][] imageSmoother(int[][] M) {
        int[][] result = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                result[i][j] = getAverage(M, i, j);
            }
        }
        
        return result;
    }
    
    private int getAverage(int[][] M, int x, int y) {
        int count = 0;
        int sum = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nextX = x + i;
                int nextY = y + j;
                if (nextX >= 0 && nextX < M.length && nextY >= 0 && nextY < M[0].length) {
                    sum += M[nextX][nextY];
                    count++;
                }
            }
        }
        
        return sum / count;
    }
}