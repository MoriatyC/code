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
    public void dfs(TreeNode root) {
        if (root != null) {
            TreeNode tmp;
            tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            dfs(root.left);
            dfs(root.right);
        }
        
    }
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
}