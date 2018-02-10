public class Solution {
    /*
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        int ret = 0;
        for (int i: A) {
            ret ^= i;
        }
        return ret;
    }
}