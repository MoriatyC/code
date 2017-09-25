class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            mid = (left + right) / 2;
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                right = mid;
            } else {
                left++;
            }
        }
        //跟哪边比较就要从哪边操作        
        return nums[right];
    }
}