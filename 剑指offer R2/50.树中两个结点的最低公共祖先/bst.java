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
    TreeNode ret;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ret = root;
        dfs(root, p, q);
        return ret;
    }
    public void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }
        if ((root.val >= p.val && root.val <= q.val) || (root.val <= p.val && root.val >= q.val)) {
            ret = root;
        } else if ((root.val >= p.val && root.val >= q.val)) {
            ret = root;
            dfs(root.left, p, q);
        } else if((root.val <= p.val && root.val <= q.val)) {
            ret = root;
            dfs(root.right, p, q);
        }
    }
}