public class Solution {
    public int minSteps(int n) {
        int ret = 0;
        int factor = n - 1;
        while (n > 1) {
            if (n % factor == 0) {
                ret += n / factor;
                n = factor;
            }
            factor--;
        }
        return ret;
    }
}