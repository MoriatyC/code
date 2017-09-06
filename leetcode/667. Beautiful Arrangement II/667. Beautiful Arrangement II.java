class Solution {
    public int[] constructArray(int n, int k) {
        int[] ret = new int[n];
        int left = 1;
        int right = n;
        for (int i = 0; i < n; i++) {
            ret[i] = k % 2 == 0 ? left++ : right--;
            if (k > 1) {
                k--;
            }
        }
                
        return ret; 
    }
}