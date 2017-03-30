public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length, ret = 0;
        Map<Integer,Integer>map = new HashMap();
        for(int i = 0; i < len; i++)
        {
            for(int j = 0; j < len; j++)
            {
                map.put(A[i] + B[j],map.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        for(int i = 0; i < len; i++)
        {
            for(int j = 0; j < len; j++)
            {
                ret += map.getOrDefault(-(C[i] + D[j]), 0);
            }
        }
        return ret;
    }
}