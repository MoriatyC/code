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
    public  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (p == null) {
            return q;
        }
        if (q == null) {
            return p;
        }
        TreeNode[] ret = new TreeNode[1];
        postOrder(root, p, q, ret);
        return ret[0];
    }
    public static boolean postOrder(TreeNode root, TreeNode p, TreeNode q, TreeNode[] ret) {
         if (root == null) {
            return false;
        }
        boolean left = postOrder(root.left, p, q, ret);
        boolean right = postOrder(root.right, p, q, ret);
        if (ret[0] == null) {
            if (left && right) {
                ret[0] = root;
                return false;
            }
            if (left || right) {
                if (root == p || root == q) {
                    ret[0] = root;
                    return false;
                }
                return true;
            }
            if (root == p || root == q) {
                return true;
            }
        }
        return false;
    }
}