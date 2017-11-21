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
    public int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        int left = dfs(root.left, depth);
        int right = dfs(root.right, depth);
        return Math.max(left, right);
    }    
    public int maxDepth(TreeNode root) {
        int ret = dfs(root, 0);
        return ret;
    }
}