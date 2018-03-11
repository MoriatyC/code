class Solution {
    public int findMaxLength(int[] nums) {
        int count = 0;
        int sum = 0;
        if (nums == null || nums.length == 0) {
            return count;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();//sum,index
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                count = Math.max(count, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return count;
    }
}