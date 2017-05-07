public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sum = new HashMap<>();
        int cur = 0;
        int ret = 0;
        sum.put(0, 1);
        for (int num : nums) {
            cur += num;
            if (sum.containsKey(cur - k)) {
                ret += sum.get(cur - k);
            } 
            sum.put(cur, sum.getOrDefault(cur, 0) + 1);
        }
        return ret;
    }
}