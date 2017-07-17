public class Solution {
    public int maxCoins(int[] nums) {
        int ret = 0;
        int n = 1;
        int[] arr = new int[nums.length + 2];
        arr[0] = 1;
        for (int i: nums) {
            if (i > 0) {
                arr[n++] = i;
            }
        }
        arr[n++] = 1;
        int[][] dp = new int[n][n];//dp[left][right]从left到right的maxcoins
        for (int i = 1; i <= n - 2; i++) {//i为区间大小
            for (int left = 1; left + i - 1 <= n - 2; left++) { //j为left的起始位置
                int right = left + i - 1;
                for (int j = left; j <= right; j++) {
                    dp[left][right] = Math.max(dp[left][right], 
                                               dp[left][j - 1] + dp[j + 1][right] + arr[left - 1] * arr[j] * arr[right + 1]);
                }//两个子问题不包括j，因为如果包括的话，j可能提前作为爆点，就不能保证是最后一个
            }
            
        }
        return dp[1][n - 2];
    }
}