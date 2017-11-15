class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ret;
        } 
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        helper(nums, 0, nums.length - 1, map);
        for (int i = 0; i < nums.length; i++) {
            ret.add(map.getOrDefault(arr[i], 0));
        }
        return ret;
    }
    public void helper(int[] nums, int left, int right, Map<Integer, Integer> map) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        helper(nums, left, mid, map);
        helper(nums, mid + 1, right, map);
        merge(nums, left, mid, right, map);
    }
    public void merge(int[] nums, int s1, int p1, int p2, Map<Integer, Integer> map) {
        int p3 = p2;
        int end = p2;
        int s2 = p1 + 1;
        int[] tmp = new int[nums.length];
        while (p1 >= s1 && p2 >= s2) {
            if (nums[p2] >= nums[p1]) {
                tmp[p3--] = nums[p2--];
            } else {
                map.put(nums[p1], map.getOrDefault(nums[p1], 0) + p2 - s2 + 1);
                tmp[p3--] = nums[p1--];
            }
        }
        while (p1 >= s1) {
            tmp[p3--] = nums[p1--];
        }
        while (p2 >= s2) {
            tmp[p3--] = nums[p2--];
        }
        for (int i = s1; i <= end; i++) {
            nums[i] = tmp[i];
        }
    }
}