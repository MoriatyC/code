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
    public int rob(TreeNode root) {
        int[] ret = helper(root);
        return Math.max(ret[0], ret[1]);
    }
    int[] helper(TreeNode root) {
        int[] now = new int[2];
        if (root == null) {
            return now;
        }//1抢  0不抢
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        now[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);//因为root没有被抢，所以我们可以抢子树也可以不抢，选最大的就可以
        now[1] = root.val + left[0] + right[0];
        return now;
    }
}