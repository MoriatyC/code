public class Solution {
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        boolean positive = true;
        if (exponent < 0) {
            exponent *= -1;
            positive = false;
        }
        double tmp = Power(base, exponent / 2);
        tmp *= tmp;
        if (exponent % 2 == 1) {
            tmp *= base;
        }
        if (!positive) {
            return 1 / tmp;
        }
        return tmp;
  }
}