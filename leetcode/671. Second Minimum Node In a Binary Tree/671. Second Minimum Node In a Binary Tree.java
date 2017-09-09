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
    int find(TreeNode root, int ret, int val) {
        if (root.left != null) {
             if (root.left.val == root.val) {
                 if (root.right.val != val) {
                     ret = Math.min(ret, root.right.val);
                    
                 } 
                 ret = find(root.left, ret, val);
                
            }
            if (root.right.val == root.val) {
                if (root.left.val != val) {
                    ret = Math.min(ret, root.left.val);
                }
                ret = find(root.right, ret, val);
                
            }
        }
       
        return ret;
    }
    public int findSecondMinimumValue(TreeNode root) {
        int ret = find(root, Integer.MAX_VALUE, root.val);
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}