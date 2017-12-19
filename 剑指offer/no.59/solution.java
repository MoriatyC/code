import java.util.List;
import java.util.ArrayList;
public class Solution {
    boolean preDfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return preDfs(left.left, right.right) && preDfs(left.right, right.left);
    }
    boolean isSymmetrical(TreeNode root)
    {
        if (root == null) {
            return true;
        }
      return preDfs(root.left, root.right);
    }
}