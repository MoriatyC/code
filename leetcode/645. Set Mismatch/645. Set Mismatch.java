public class Solution {
    public int[] findErrorNums(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return new int[]{-1, -1};
        }
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int dup = 0;
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                dup = nums[i];
            } else {
                set.add(nums[i]);
            }
            sum += nums[i];
        }
        if (len * (len + 1) / 2 > sum) {
            return new int[]{dup, dup + len * (len + 1) / 2 - sum};
        } else {
            return new int[]{dup, dup - (sum - len * (len + 1) / 2)};    
        }
    }
}