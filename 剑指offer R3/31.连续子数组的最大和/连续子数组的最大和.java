public class Solution {
    public int FindGreatestSumOfSubArray(int[] arr) {
        if (arr == null  arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = arr[0];
        for (int i = 1; i  arr.length; i++) {
            if (dp[i - 1]  0) {
                dp[i - 1] = 0;
            } 
            dp[i] = dp[i - 1] + arr[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }
}