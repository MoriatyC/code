class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int ret = 1;
        int cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur++;
            } else {
                ret = Math.max(cur, ret);
                cur = 1;
            }
        }
        return Math.max(cur, ret);
    }
}