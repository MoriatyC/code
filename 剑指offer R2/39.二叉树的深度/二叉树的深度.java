/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    static int ret = 0;
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] ret = {0};
        dfs(root, ret, 0);
        return ret[0];
    }
    public void dfs(TreeNode root, int[] ret, int deep) {
        if (root == null) {
            ret[0] = Math.max(ret[0], deep);
            return;
        }
        deep++;
        dfs(root.left, ret, deep);
        dfs(root.right, ret, deep);
    }
}