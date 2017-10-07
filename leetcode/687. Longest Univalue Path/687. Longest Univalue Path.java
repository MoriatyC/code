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
    int max = Integer.MIN_VALUE;
    int dfs(TreeNode root, int path) {
        int left = 0;
        int right = 0;
        if (root.left != null) {
            //如果和子节点一样就计算否则就等于0
            if (root.val == root.left.val) {
                left = dfs(root.left, 1);//如果当前节点和子节点相同，返回子树最大长度
                //标注当前节点和子节点的path权重
            } else {
                dfs(root.left, 0);
            }
        }
        if (root.right != null) {
            if (root.val == root.right.val) {
                right = dfs(root.right, 1);
            } else {
                dfs(root.right, 0);
            }
        }
        // max = Math.max(max, helper(path, left, right));
        max = Math.max(max, left + right);
        return Math.max(path + left, path + right);//每次返回左子树和右子树中较长的那个
        //整个函数的返回值是父节点在当前节点分支上的最长路径
    }
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return max;
    }
}