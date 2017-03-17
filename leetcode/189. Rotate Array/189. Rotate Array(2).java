public class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
           if ((n == 0) || (k <= 0))
            {
                return;
            }
            
            // Make a copy of nums
            int[] numsCopy = new int[nums.length];
            for (int i = 0; i < n; i++)
            {
                numsCopy[i] = nums[i];
            }
            
            // Rotate the elements.
            for (int i = 0; i < n; i++)
            {
                nums[(i + k)%n] = numsCopy[i];
            }
    }
    
   
    }