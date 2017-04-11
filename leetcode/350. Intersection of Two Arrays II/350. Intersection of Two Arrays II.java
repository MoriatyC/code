public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<Integer>();
        while(true)
        {
            if(i >= len1 || j >= len2) break;
            if(nums1[i] == nums2[j])
            {
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] > nums2[j])
            {
                j++;
            }
            else
            {
                i++;
            }
        }
        int[] ret = new int[list.size()];
        for(i = 0; i < list.size(); i++)
        {
            ret[i] = list.get(i);
        }
        return ret;
    }
}