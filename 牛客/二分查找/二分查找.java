import java.util.*;

public class BinarySearch {
    public int getPos(int[] A, int n, int val) {
        if (A == null || A.length == 0 || n <= 0) {
            return -1;
        }
        int l = 0;
        int r = A.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (val > A[mid] ) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (A[l] == val) {
            return l;
        }
        if (A[r] == val) {
            return r;
        }
        return -1;
    }
}