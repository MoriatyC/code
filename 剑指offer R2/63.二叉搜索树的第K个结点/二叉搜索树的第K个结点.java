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
    TreeNode KthNode(TreeNode root, int k)
    {
        //中序遍历
        if (root == null || k <= 0) {
            return null;
        }
        return dfs(root, new int[]{0}, k);
    }
    TreeNode dfs(TreeNode root, int[] index, int k) {
        TreeNode ret = null;
        if (root.left != null) {
            ret = dfs(root.left, index, k);
            if (ret != null) {
                return ret;
            }
        }
        if (++index[0] == k) {
            return root;
        }
        if (root.right != null) {
            ret = dfs(root.right, index, k);
        }
        return ret;
    }

}
