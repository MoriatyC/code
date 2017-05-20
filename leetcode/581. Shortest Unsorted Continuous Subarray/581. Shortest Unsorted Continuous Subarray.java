public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int start = 0;
        int end = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != temp[i]) {
                start = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != temp [i]) {
                end = i + 1;
                break;
            }
        }
        return end - start;
    }
}