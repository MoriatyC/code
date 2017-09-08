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
    TreeNode findRight(TreeNode root) {
        if (root.right != null) {
            return findRight(root.right);
        }
        return root;
    }
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            TreeNode tmp = findRight(root.left);
            tmp.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
        
    }
}