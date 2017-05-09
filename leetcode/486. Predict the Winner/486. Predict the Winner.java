public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int count = 0;
        int j;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            count += nums[i];
            dp[i][i] = nums[i];
        }
        for (int length = 1; length < len; length++) {
            for (int i = 0; i < len - length; i++) { 
                j = i + length;
				//dp[i][j]������I-J��һ�������ܴﵽ����óɼ�
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j] ,nums[j] - dp[i][j - 1]);
            }
        }

        return dp[0][len - 1] >= 0;
    }
}