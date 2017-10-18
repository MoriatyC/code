package first_maven;

import java.util.LinkedList;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class TreeDemo {
    static void solution(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode tmp;
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            if (tmp == null) {
                System.out.println("null");
            } else {
                System.out.println(tmp.val);
                if (tmp.left != null || tmp.right !=null) {
                    queue.offer(tmp.left);
                    queue.offer(tmp.right);
                }
            }
            
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
       
    }

}
