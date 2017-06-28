public class Solution {
    public int findLHS(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int ret = 0;
        int cur = 0;
        if (nums[1] <= nums[0] + 1) {
            cur = 1;
        }
        Arrays.sort(nums);
        int start = 0;
        int jump = 0;
        boolean flag = true;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] <= nums[start] + 1) {
                cur++;
                if (i == nums.length - 1) {
                    if (nums[i] == nums[start]) {
                        cur = 0;
                    }
                    ret = Math.max(ret, cur);
                }
                if (flag && nums[i] > nums[start]) {
                    jump = i;
                    flag = false;
                }
            } else if (flag) {
                if (nums[i - 1] == nums[start]) {
                    cur = 0;
                }
                start = i;
                jump = i;
                ret = Math.max(ret, cur);
                cur = 1;
            } else {
                if (nums[i - 1] == nums[start]) {
                    cur = 0;
                }
                flag = true;
                i = jump;
                start = jump;
                ret = Math.max(ret, cur);
                cur = 1;
            }
        }
        return ret;
    }
}