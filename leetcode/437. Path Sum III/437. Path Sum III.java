/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    void dfs(TreeNode root, Map<Integer, Integer> map, int curSum, int target, int[] ret) {
        if (root == null) {
            return;
        }
        curSum += root.val;//map中存储的是前缀和的数目
        if (map.containsKey(curSum - target)) {//curSum - target是到当前节点为止的总和比target要多出了多少，如果map里有这样的前缀，这个前缀的下一个节点到目标节点就是一条可行的解路径
            ret[0] += map.get(curSum - target);
        }
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        dfs(root.left, map, curSum, target, ret);
        dfs(root.right, map, curSum, target, ret);
        map.put(curSum, map.get(curSum) - 1);
    }
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int[] ret = new int[1];
        dfs(root, map, 0, sum, ret);
        return ret[0];
    }
}