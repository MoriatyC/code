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
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        int next = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pop();
            list.add(cur.val);
            count--;
            if (cur.left != null) {
                next++;
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                next++;
                queue.offer(cur.right);
            }
            if (count == 0) {
                ret.add(new ArrayList<Integer>(list));
                count = next;
                next = 0;
                list.clear();
            }
        }
        return ret;
    }
    
}

