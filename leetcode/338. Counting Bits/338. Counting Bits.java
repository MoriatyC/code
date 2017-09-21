class Solution {
    public int[] countBits(int num) {
        if (num <= 0) {
            return new int[]{0};
        }
        if (num == 1) {
            return new int[]{0,1};
        }
        int[] ret = new int[num + 1];
        ret[0] = 0;
        ret[1] = 1;
        for (int i = 2; i <= num; i++) {
            ret[i] = ret[i / 2];
            if (i % 2 == 1) {
                ret[i]++;
            }
        }
        return ret;
    }
}