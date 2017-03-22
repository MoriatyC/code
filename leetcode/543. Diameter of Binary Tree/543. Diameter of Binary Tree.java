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
    int maxLength = 0;
 
    int dfs(TreeNode root)
 {
     int left = 0, right = 0, depth = 0;
     if(root.left != null)
     {
         left = dfs(root.left);
     }
     if(root.right != null)
     {
         right = dfs(root.right);
     }
     maxLength = Math.max(left + right, maxLength);
     depth = Math.max(left, right);
     return depth + 1;
 }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) 
        {
            return 0;
        }
        dfs(root);
        return maxLength;
    }
}