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
        TreeNode last = inOrder(root, null);
        while (last!= null && last.left != null) {
            last = last.left;
        }
        return last;
    }
    public TreeNode inOrder(TreeNode root, TreeNode last) {
        if (root == null) {
            return last;
        }
        last = inOrder(root.left, last);
        root.left = last;
        if (last != null) {
            last.right = root;
        }
        last = root;
        last = inOrder(root.right, last);
        return last;
    }
}