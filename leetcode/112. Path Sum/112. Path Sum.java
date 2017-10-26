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
    public boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }
    public boolean helper(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if ((root.left == null) && (root.right == null)) {
            if (root.val == sum) {
                return true;
            }
            return false;
        }
        boolean left = false;
        boolean right = false;
        sum -= root.val;
        left = helper(root.left, sum);
        right = helper(root.right, sum);
        return left || right;
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return helper(root, sum);
    }
}