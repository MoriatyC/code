public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int num: nums) {
            list.add(num);
        }
        back(ret, list, cur);
        return ret;
        
    }
    void back(List<List<Integer>> ret, List<Integer> list, List<Integer> cur) {
        if (list.size() == 0) {
            ret.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
                int tmp = list.get(i);
                cur.add(tmp);
                list.remove(i);
                back(ret, list, cur);
                list.add(i, tmp);
                cur.remove(cur.size() - 1);
            }
    }
}