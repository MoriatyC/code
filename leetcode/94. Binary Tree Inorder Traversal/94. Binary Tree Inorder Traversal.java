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
     void dfs(TreeNode root,List<Integer> ret)
 {
     if(root == null) return ;
     dfs(root.left,ret);
     ret.add(root.val);
     dfs(root.right,ret);
 }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList();
        dfs(root,ret);
        return ret;
    }
}