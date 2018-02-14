/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int dfs(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        depth++;
        return Math.max(dfs(node.left, depth), dfs(node.right, depth));
    }
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }
}