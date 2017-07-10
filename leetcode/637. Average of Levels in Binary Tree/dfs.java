/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
   
    void dfs(TreeNode root, int deep, Map<Integer, long[]> map) {
        if (root == null) {
            return;
        }
        long[] cur = map.getOrDefault(deep, new long[2]);
        cur[0] += root.val;
        cur[1] ++;
        map.put(deep, cur);
        dfs(root.left, deep + 1, map);
        dfs(root.right, deep + 1, map);
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        Map<Integer, long[]> map = new HashMap<>();
        dfs(root, 0, map);
        int size = map.size();
        long[] cur;
        for (int i = 0; i < size; i++) {
            cur = map.get(i);
            ret.add(1.0 * cur[0] / cur[1]);
        }
        return ret;
    }
}