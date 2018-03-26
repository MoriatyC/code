import java.util.ArrayList;
import java.util.*;
public class Solution {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }
        int[] ret = new int[A.length];
        Arrays.fill(ret, 1);
        for (int i = 1; i < A.length; i++) {
            ret[i] = ret[i - 1] * A[i - 1];
        }
        int tmp = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            ret[i] *= tmp;
            tmp *= A[i];
        }
        return ret;
    }
}