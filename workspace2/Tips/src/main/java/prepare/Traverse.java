package prepare;

import java.util.*;
import java.util.LinkedList;
import java.util.List;

/** 
* @author : Menghui Chen 
* @version ：2018年3月12日 上午9:20:07 
* @Description:
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Traverse {
    public static List<Integer> preorder(TreeNode root) {
        
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                ret.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        return ret;
    }
    public static List<Integer> inorder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                ret.add(root.val);
                root = root.right;
            }
        }
        return ret;
    }
    public static List<Integer> postorder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> ret = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                ret.push(root.val);
                root = root.right;
            } else {
                root = stack.pop();
                root = root.left;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(7);
        a1.left = a2;
        a1.right = a3;
        a3.left = a4;
        a3.right = a5;
        List<Integer> ret = postorder(a1);
        for (int item: ret) {
            System.out.println(item);
        }
    }
}
