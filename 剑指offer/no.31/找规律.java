class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        int cur = nums[0];
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                ret = Math.max(ret, cur);
            }
            if (cur > 0) {
                cur += nums[i];
            } else {
                cur = nums[i];                   
            }
        }
        return Math.max(ret, cur);
    }
}