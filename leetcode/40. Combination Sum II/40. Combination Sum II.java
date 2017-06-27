public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        backstrack(ret, new ArrayList<>(), candidates.length - 1, target, candidates);
        return ret;
    }
    void backstrack(List<List<Integer>> ret, List<Integer> list, int start, int remain, int[] nums) {
       if (remain == 0) {
           ret.add(new ArrayList<>(list));
       } else {
           for (int i = start; i >=0; i--) {
               if (start != i && nums[i] == nums[i + 1]) {
                   continue;
               }
               if (remain - nums[i] >= 0) {
                   list.add(nums[i]);
                   backstrack(ret, list, i - 1, remain - nums[i], nums);
                   list.remove(list.size() - 1);
               }
           }
       }
    }
}