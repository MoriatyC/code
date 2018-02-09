class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length) {
            int[] tmp = A;
            A = B;
            B = tmp;
        }
        int m = A.length;
        int n = B.length;
        int iMin = 0;
        int iMax = m;
        int halfLen = (n + m + 1) / 2;
        double leftMax = 0;
        double rightMin = 0;
        while (iMin <= iMax) {
            int i = iMin + (iMax - iMin) / 2;
            int j = halfLen - i;
            if (i < m && B[j - 1] > A[i]) {
                iMin = i + 1;
            } else if (i > 0 && A[i -1] > B[j]) {
                iMax = i - 1;
            } else {
                if (i == 0) {
                    leftMax = B[j - 1];
                } else if (j == 0) {
                    leftMax = A[i - 1];
                } else {
                    leftMax = Math.max(A[i - 1], B[j - 1]);
                }
                if ((n + m) % 2 == 1) {
                    return leftMax;
                }
                if (i == m) {
                    rightMin = B[j];
                } else if (j == n) {
                    rightMin = A[i];
                } else {
                    rightMin = Math.min(B[j], A[i]);
                }
                return (rightMin + leftMax) / 2.0;
            }
        }
         return 0;
    }
}