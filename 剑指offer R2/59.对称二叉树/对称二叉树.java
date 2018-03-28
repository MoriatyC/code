import java.util.List;
import java.util.ArrayList;
public class Solution {
    boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            return dfs(root.left, root.right);
        } else if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
    boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if(left.val == right.val) {
            return dfs(left.left, right.right) && dfs(left.right, right.left);
        }
        return false;
    }
}
/*
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

*/