/**

}
*/
public class Solution {
    TreeNode last = null;
    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return root;
        }
        inorder(root);
        while (last.left != null) {
            last = last.left;
        }
        return last;
    }
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        root.left = last;
        if (last != null) {
            last.right = root;
        }
        last = root;
        inorder(root.right);
    }
}