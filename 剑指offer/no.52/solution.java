import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        if (A == null || A.length <= 1) {
            return null;
        }
        int[] ret = new int[A.length];
        ret[0] = 1;
        int tmp = 1;
        for (int i = 1; i < A.length; i++) {
            ret[i] = ret[i - 1] * A[i - 1];
        }

        for (int i = A.length - 2; i >= 0; i--) {
            ret[i] *= tmp * A[i + 1];
            tmp *= A[i + 1];
        }
        return ret;
    }
}