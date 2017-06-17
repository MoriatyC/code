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
    int ret = 0;
    int count = 0;
    boolean flag = false;
    void dfs(TreeNode root, int k) {
        if (root == null || flag) {
            return;
        }
        dfs(root.left, k);
        count++;
        if (count == k) {
            ret = root.val;
            flag = true;
            return;
        }
        dfs(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        dfs(root, k);
        return this.ret;
        
    }
}