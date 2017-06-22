public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int cur;
        int ret = 0;
        int tmp;
        for (List<Integer> row: wall) {
            cur = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                cur += row.get(i);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                ret = Math.max(ret, map.get(cur));//��
            }
        }
        return wall.size() - ret;//������ǽ��
    }
}