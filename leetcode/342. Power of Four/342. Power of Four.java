public class Solution {
    public boolean isPowerOfFour(int num) {
        return ((0b1010101010101010101010101010101 & num) > 0) && ((num & (num - 1)) == 0);
    }
}