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
    public int getDep(TreeNode root, boolean[] ret) {
        if (ret[0] ==false || root == null) {
            return 0;
        }
        int left = getDep(root.left, ret);
        int right = getDep(root.right, ret);
        if (Math.abs(left - right) > 1) {
            ret[0] = false;
        }
        return Math.max(left, right) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        boolean[] ret = {true};
        getDep(root, ret);
        return ret[0];
    }
}