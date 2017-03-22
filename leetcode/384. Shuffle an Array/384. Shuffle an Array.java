public class Solution {
    private int[] nums;
    private Random random;
    private int len;
    public Solution(int[] nums) {
         this.nums = nums;
         random = new Random();
         len = nums.length;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
       return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] temp = nums.clone();
        for(int i = 0; i < nums.length; i++)
        {
            swap(temp,i,random.nextInt(len));
        }
        return temp;
    }
    public void swap(int[] temp,int i,int j)
    {
        int tem = temp[i];
        temp[i] = temp[j];
        temp[j] = tem;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */