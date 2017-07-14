public class Solution {
    public int bulbSwitch(int n) {
        if (n < 0) {
            return Integer.MIN_VALUE;
        }
        return (int)Math.sqrt(n);
    }
}