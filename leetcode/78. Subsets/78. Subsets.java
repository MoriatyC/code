public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        backstrack(ret, new ArrayList<>(), nums, 0);
        ret.add(new ArrayList<>());
        return ret;
    }
    void backstrack(List<List<Integer>> ret, List<Integer> list, int[] nums, int i) {
        for (; i < nums.length; i++) {
            list.add(nums[i]);
            ret.add(new ArrayList<>(list));
            backstrack(ret, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}