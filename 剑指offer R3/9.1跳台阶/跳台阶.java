public class Solution {
    public int JumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        int[] ret = new int[target + 1];
        ret[0] = 0;
        ret[1] = 1;
        ret[2] = 2;
        for (int i = 3; i <= target; i++) {
            ret[i] = ret[i - 1] + ret[i - 2];
        }
        return ret[target];
    }
}