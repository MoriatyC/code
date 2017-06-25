public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        backstrack(ret, new ArrayList<>(), nums, 0);
        return ret;
    }
    void backstrack(List<List<Integer>> ret, List<Integer> list, int[] nums, int i) {
        if (!ret.contains(list)) {
            ret.add(new ArrayList(list));
        }
        for (; i < nums.length; i++) {
            list.add(nums[i]);
            backstrack(ret, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        backstrack(ret, new ArrayList<>(), nums, 0);
        return ret;
    }
    void backstrack(List<List<Integer>> ret, List<Integer> list, int[] nums, int start) {
        ret.add(new ArrayList(list));
        for (int i = start; i < nums.length; i++) {
            //如果例子是1、2、2,当是同一轮循环的时候第二个2要被省略，如果是子循环第二个2不能省略
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backstrack(ret, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}