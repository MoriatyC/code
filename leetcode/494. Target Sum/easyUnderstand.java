public class Solution {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int i: nums) {
            sum += i;
        } 
        if (sum < s || -sum > s) {
            return 0;
        }
        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;//dp【i】表示当前和为i的组合有多少个
        for (int i: nums) {
            int[] next = new int[2 * sum + 1];
            for (int j = 0; j < 2 * sum + 1; j++) {
                if (dp[j] != 0) {
                    next[j + i] += dp[j];
                    next[j - i] += dp[j];
                }
            }
            dp = next;
        }
        return dp[sum + s];
    }
}