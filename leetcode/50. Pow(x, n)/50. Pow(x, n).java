class Solution {
    public double myPow(double x, int n) {
        double ret;
        if (equal(x, 0.0) && n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return pow(x, n);
        } else {
            if (n == Integer.MIN_VALUE) {
                n++;
                return 1.0 / (pow(x, -n) * x);
            } else {
                return 1.0 / pow(x, -n);
            }
        }
    }
    public double pow(double x, int n) {
        if (n == 1) {
            return x;
        }
        double ret = pow(x, n >> 1);
        ret *= ret;
        if ((n & 1) == 1) {
            ret *= x;
        }
        return ret;
    }
    public boolean equal(double x, double y) {
        if (x - y < 0.0000001 && x - y > -0.0000001) {
            return true;
        }
        return false;
    }
}