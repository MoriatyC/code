public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        backstrack(ret, new ArrayList<>(), new boolean[nums.length], nums);
        return ret;
    }
    void backstrack(List<List<Integer>> ret, List<Integer> list, boolean[] used, int[] nums) {
        if (list.size() == nums.length) {
            ret.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i != 0 && !used[i - 1] && nums[i] == nums[i - 1])) {
                    continue;
                }
                used[i] = true;
                list.add(nums[i]);
                backstrack(ret, list, used, nums);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
        
    }
}