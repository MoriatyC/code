public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);
        List<Integer> cur;
        
        for (int i = 1; i < arrays.size(); i++) {
            cur = arrays.get(i);
            result = Math.max(result, Math.abs(cur.get(0) - max));
            result = Math.max(result, Math.abs(cur.get(cur.size() - 1) - min));
            max = Math.max(max, cur.get(cur.size() - 1));
            min = Math.min(min, cur.get(0));
        }
        
        return result;
    }
}