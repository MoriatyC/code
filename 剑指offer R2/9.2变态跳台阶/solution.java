public class Solution {
    public int JumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        }
        return (int)Math.pow(2, target - 1);
    }
}