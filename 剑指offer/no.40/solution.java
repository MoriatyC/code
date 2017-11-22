class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[2];
        }
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = ret ^ nums[i];
        }
        int bound = 1;
        while ((bound & ret) < 1) {
            bound = bound << 1;
        }
        System.out.println(bound);
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & bound) == 0) {
                left ^= nums[i];
            } else {
                right ^= nums[i];
            }
        }
        return new int[]{left, right};
    }
}