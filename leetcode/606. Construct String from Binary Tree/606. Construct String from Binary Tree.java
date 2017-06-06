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
    void dfs(TreeNode t, StringBuilder sb) {
        if (t == null) {
            return;
        }
        sb.append("(").append(t.val);
        dfs(t.left, sb);
        if (t.left == null && t.right != null) {
            sb.append("()");
        }
        dfs(t.right, sb);
        sb.append(")");
    }
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        dfs(t, sb);
        return sb.deleteCharAt(0).deleteCharAt(sb.length()-1).toString();
    }
}