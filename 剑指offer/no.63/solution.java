/*
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
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null) {
            return null;
        }
        TreeNode[] ret = new TreeNode[1];
        int[] index = {0};
        dfs(pRoot, k, ret, index);
        return ret[0];
    }
	void dfs(TreeNode pRoot, int k, TreeNode[] ret, int[] index) {
        if (pRoot == null) {
            return;
        }
        dfs(pRoot.left, k, ret, index);
        index[0]++;
        if (index[0] == k) {
            ret[0] = pRoot;
            return;
        }
        dfs(pRoot.right, k, ret, index);
    }

}