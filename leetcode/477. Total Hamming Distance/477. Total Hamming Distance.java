public class Solution {
    public int totalHammingDistance(int[] nums) {
      // the product of the total 0 and total 1 is the haming distance of that bit position
      int bitcount = 0, ret = 0;
      int len = nums.length;
      for(int i = 0; i < 32; i++)
      {
          bitcount = 0;
          for(int j = 0; j < len; j++)
          {
              bitcount += (nums[j] >> i) & 1;
          }
          ret += bitcount * (len - bitcount);
      }
      return ret;
    }
}