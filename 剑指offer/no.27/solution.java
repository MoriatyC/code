package first_maven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class TreeDemo {
    public TreeNode convert(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode last = null;
        last = helper(root, last);
        while (last.left != null) {
            last = last.left;
        }
        return last;
    }
    public TreeNode helper(TreeNode root, TreeNode last) {//返回以root为根的链表的最右边的节点      
        if (root.left != null) {
            last = helper(root.left, last);
        }
        
        //连接操作
        root.left = last;
        if (last != null) {
            last.right = root;
        }
        last = root;
        
        
        if (root.right != null) {
            last = helper(root.right, last);
        }
        return last;
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
       
    }

}
