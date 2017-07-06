public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        n--;
        m--;
        for (; n >= 0 && m >=0; i--) {
            if (nums1[m] > nums2[n]) {
                nums1[i] = nums1[m--];
            } else {
                nums1[i] = nums2[n--];
            }
        }
        
        while (n >=0) {//n=i¶¼Ò»Ñù
            nums1[i--] = nums2[n--];           
        }          
        
    }
}