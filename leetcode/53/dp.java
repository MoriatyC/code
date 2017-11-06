class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int ret = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];//以第I个数结尾的子数组最大和
        for (int i = 0; i < dp.length; i++) {
            if (i == 0 || dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}