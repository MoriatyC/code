/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) {
            return root;
        }
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        dfs(root, v, d, 1);
        return root;
    }
    void dfs(TreeNode root, int value, int d, int cur) {
        if (root == null) {
            return;
        }
        if (cur + 1 == d) {
            TreeNode left = new TreeNode(value);
            TreeNode right = new TreeNode(value);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
        }
        dfs(root.left, value, d, cur + 1);
        dfs(root.right, value, d, cur + 1);
    }
}