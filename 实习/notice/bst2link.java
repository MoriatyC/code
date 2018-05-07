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
    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode last = inOrder(root, null);
        while (last.left != null) {
             last = last.left;   
        }
        return last;
    }
    public TreeNode inOrder(TreeNode root, TreeNode last) {
        if (root == null) {
            return last;
        }
        TreeNode left = inOrder(root.left,last);
        root.left = left;
        if (left != null) {
            left.right = root;
        }
        last = root;
        TreeNode right = inOrder(root.right, last);
        return right;
    }
}