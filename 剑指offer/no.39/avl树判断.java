import java.util.*;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/

public class Balance{
    public boolean isBalance(TreeNode root) {
        int[] depth = {0};
        boolean res = isBalance(root, depth);
        return res;
    }
    public static boolean isBalance(TreeNode root, int[] dep){
        if(root == null){
            dep[0] = 0;
            return true;
        }
        int[] left = {0};//左子树深度
        int[] right = {0};//右子树深度
        if (isBalance(root.left, left) && isBalance(root.right, right)) {
            int diff = left[0] - right[0];
            if (diff >= -1 && diff <= 1) {
                dep[0] = Math.max(left[0], right[0]) + 1;
                return true;
            }
        }
        return false;
    }
}