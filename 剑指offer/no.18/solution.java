package first_maven;

import java.util.List;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class TreeDemo {
    static boolean hasSubtree(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return false;
        }
        boolean ret = false;
        if (a.val == b.val && isSame(a, b)) {
            return true;
        }
        return hasSubtree(a.left, b) || hasSubtree(a.right, b);
    }
    static boolean isSame(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if ((a == null) || a.val != b.val) {
            return false;
        } 
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        a.equals(b);
    }

}
