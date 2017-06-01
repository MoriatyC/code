public class Solution {
    public int arrayNesting(int[] nums) {
        int ret = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
              if (nums[i] != -1) {//说明这个环还没有被访问
                int start = nums[i];
                count = 0;
                while (nums[start] != -1) {
                    int temp = nums[start];
                    nums[start] = -1;
                    start = temp;
                    count++;
                }
            }
            ret = Math.max(ret, count);
        }
        return ret;        
    }
}