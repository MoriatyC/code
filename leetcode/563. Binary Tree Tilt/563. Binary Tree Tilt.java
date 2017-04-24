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
    int result = 0;
    int dfs(TreeNode root){
        if(root == null)
        {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        result += Math.abs(left - right);
        return root.val + left + right;
    }
    public int findTilt(TreeNode root) {
         dfs(root);
         return result;
    }
}