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
            return pRoot;
        }
        TreeNode[] ret = new TreeNode[1];
        int[] index = {0};
        inorder(pRoot, k, index, ret);
        return ret[0];
    }
    public void inorder(TreeNode root, int k, int[] index, TreeNode[] ret) {
        if (root == null) {
            return;
        }
        inorder(root.left, k, index, ret);
        index[0]++;
        if (index[0] == k) {
            ret[0] = root;
        }
        inorder(root.right, k, index, ret);
    }

}