import java.util.ArrayList;
import java.util.LinkedList;

/*
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
    ArrayList<ArrayList<Integer> > Print(TreeNode root) {
        if (root == null) {
            return new ArrayList<ArrayList<Integer> >();
        }
        ArrayList<ArrayList<Integer> > ret = new ArrayList<ArrayList<Integer> >();
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    TreeNode cur = queue1.poll();
                    list.add(cur.val);
                    if (cur.left != null) {
                        queue2.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue2.offer(cur.right);
                    }
                }
                ret.add(new ArrayList<Integer>(list));
            } else {
                while (!queue2.isEmpty()) {
                    TreeNode cur = queue2.poll();
                    list.add(cur.val);
                    if (cur.left != null) {
                        queue1.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue1.offer(cur.right);
                    }
                }
                ret.add(new ArrayList<Integer>(list));
            }
            list.clear();
        }
        return ret;
    }
    
}

