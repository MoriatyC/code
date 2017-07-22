public class Solution {
    public int singleNonDuplicate(int[] nums) {
        //single一定出现在偶数的index上
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid % 2 == 1) {
                mid--;//保证mid是偶数的index
            }
            if (nums[mid] == nums[mid + 1]) {
                start = mid + 2;
            } else {
                end = mid;
            }
        }
        return nums[end];//end和start都一样因为二分到最后区间范围是1
    }
    
}