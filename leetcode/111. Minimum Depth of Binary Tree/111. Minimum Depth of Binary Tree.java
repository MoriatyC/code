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
    public void dfs(TreeNode root, int[] ret, int depth) {
        depth++;
        if (root.left == null && root.right == null) {
            ret[0] = Math.min(ret[0], depth);
        }
        if (root.left != null) {
            dfs(root.left, ret, depth);
        }
        if (root.right != null) {
            dfs(root.right, ret, depth);
        }
    }
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] ret = {Integer.MAX_VALUE};
        dfs(root, ret, 0);
        return ret[0];
    }
}