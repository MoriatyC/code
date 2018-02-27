public class Solution {
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            if (base - 0 < 0.0000001 && base - 0 > -0.0000001) {
                return 0;
            }
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        boolean positive = true;
        if (exponent < 0) {
            positive = false;
            exponent *= -1;
        }
        double ret = Power(base, exponent >> 1);
        if ((exponent & 1) == 0) {
            ret = ret * ret;
        } else {
            ret = ret * ret *base;
        }
        return positive ? ret : 1 / ret;        
  }
}