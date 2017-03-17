public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] temp = new int [nums.length];
        int index = 0;
        while(k > 0)
        {
            temp[index++] = nums[nums.length - k];
            k--;
        }
        for(int i = 0;index < nums.length;i++)
        {
            temp[index++] = nums[i];
        }
        for(int i = 0; i < nums.length; i++)
        {
            nums[i] = temp[i];
        }
    }
}