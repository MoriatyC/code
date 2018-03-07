public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = array[i];
            } else {
                dp[i] = dp[i - 1] + array[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}