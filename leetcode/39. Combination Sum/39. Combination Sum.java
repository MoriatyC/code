public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        backstrack(ret, new ArrayList<>(),candidates, target, candidates.length - 1);
        return ret;
    }
    void backstrack(List<List<Integer>> ret, List<Integer> list, int[] candidates, int remain, int start) {
        if (remain == 0) {
            ret.add(new ArrayList<>(list));
        } else {
            for (int i = start; i >= 0; i--) {
                if (candidates[i] <= remain) {
                    list.add(candidates[i]);
                    backstrack(ret, list, candidates, remain - candidates[i], i);
                    list.remove(list.size() - 1);
                } 
            }
        }
    }
}