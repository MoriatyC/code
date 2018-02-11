public class Solution {
    /*
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int n) {
        List<Long> list = new ArrayList<>();
        boolean positive = true;
        long tmp = n;
        if (n < 0) {
            positive = false;
            tmp = -n;
        }
        while (tmp != 0) {
            list.add(tmp % 10) ;
            tmp /= 10;
        }
        tmp = 0;
        for (int i = 0; i < list.size(); i++) {
            tmp = tmp * 10 + list.get(i);
        }
        if (!positive) {
            tmp = -tmp;
        }
        if (tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)tmp;
    }
}