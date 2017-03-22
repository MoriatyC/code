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
    void dfs(TreeNode root, int[] sum)
    {
        if(root == null) return;
        dfs(root.right, sum);
        sum[0] += root.val;
        root.val = sum[0];
        dfs(root.left, sum);
    }
     public TreeNode convertBST(TreeNode root) {
        int[] sum = {0};
        dfs(root,sum);
        return root;
    }
}