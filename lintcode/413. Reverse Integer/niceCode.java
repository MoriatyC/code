public class Solution {
    /*
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int x) {
        int ret = 0;
        while(x != 0)
        {
            int tmp = ret * 10 + x % 10;
            if ((tmp - x % 10) / 10 != ret) {
                return 0;
            }
            ret = tmp;
            x /= 10;
        }
        return ret ;
    }
}