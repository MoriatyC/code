public class Solution {
    public int RectCover(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] ret = new int[n + 1];
        ret[1] = 1;
        ret[2] = 2;
        for (int i = 3; i <= n; i++) {
            ret[i] = ret[i - 1] + ret[i - 2];
        }
        return ret[n];
    }
}