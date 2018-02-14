public class Solution {
    /**
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne(int[] digits) {
        int in = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int tmp = digits[i] + in;
            digits[i] = tmp % 10;
            in = tmp / 10;
        }
        if (in == 1) {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            return ret;
        }
        return digits;
    }
}