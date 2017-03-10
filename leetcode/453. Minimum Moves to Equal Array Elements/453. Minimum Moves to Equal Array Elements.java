public class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            sum += nums[i];
            min = Math.min(min,nums[i]);
        }
        return sum - min * nums.length;
    }
}