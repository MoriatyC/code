public class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        do
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(fast != slow);
        int find = 0;
        do{
            find = nums[find];
            slow = nums[slow];
        }
        while(find != slow);
        return find;
    }
}