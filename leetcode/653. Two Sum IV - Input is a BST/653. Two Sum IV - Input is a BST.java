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
    void dfs(TreeNode root, int k, Set<Integer> set, boolean flag) {
        if (root == null) {
            return;
        }
        int cur = k - root.val;
        if (set.contains(root.val)) {
            flag = true;
            return;
        }
        set.add(cur);
        dfs(root.left, k, set, flag);
        dfs(root.right, k, set, flag);
    }
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        boolean flag = false;
        dfs(root, k, set, flag);
        return flag;
    }
}