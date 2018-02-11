public class Solution {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        int count = 0;
        int ret = nums.get(0);
        for (int i: nums) {
            if (count == 0) {
                count++;
                ret = i;
            } else {
                if (ret == i) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return ret;
    }
}