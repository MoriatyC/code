import java.util.ArrayList;
import java.util.*;
public class Solution {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int[] ret = new int[A.length];
        ret[0] = 1;
        for (int i = 1; i < A.length; i++) {
            ret[i] = ret[i - 1] * A[i - 1];
        }
        int tmp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            tmp *= A[i + 1];
            ret[i] *= tmp;
        }
        return ret;
    }
}