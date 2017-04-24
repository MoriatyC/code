public class Solution {
    public int arrayPairSum(int[] nums) {
        int ret = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i += 2)
        {
            ret += nums[i];
        }
        return ret;
    }
}