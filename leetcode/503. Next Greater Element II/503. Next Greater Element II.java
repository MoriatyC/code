public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < len * 2 - 1; i ++)
        {
            if( i < len)
            {
                ret[i] = -1;
            }
            int index = i % len;
            while(!stack.isEmpty() && nums[stack.peek()] < nums[index])
            {
                ret[stack.pop()] = nums[index];
            }
            if(i < len)
            {
                stack.push(i);
            }
        }
        return ret;
    }
}