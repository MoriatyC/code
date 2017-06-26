public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        backstrack(ret, new ArrayList<>(), nums);
        return ret;
        
    }
    void backstrack(List<List<Integer>> ret, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            ret.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) {
                    continue;
                }
                list.add(nums[i]);
                backstrack(ret, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}