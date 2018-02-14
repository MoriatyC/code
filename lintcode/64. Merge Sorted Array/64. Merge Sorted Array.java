public class Solution {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int index = m + n - 1;
        m--;
        n--;
        while (n >= 0 && m >= 0) {
            if (A[m] > B[n]) {
                A[index--] = A[m--];
            } else {
                A[index--] = B[n--];
            }
        }
        while (n >=0) {
            A[index--] = B[n--];
        }
    }
}