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
    public ArrayList<ArrayList<Integer> > Print(TreeNode root) {
		ArrayList<ArrayList<Integer> > ret = new ArrayList<>();
        if (root != null) {
            LinkedList<TreeNode> dequeue = new LinkedList<>();
            dequeue.offer(root);
            int left = 1;
            int cur = 1;
            int next = 0;
            TreeNode node;
            ArrayList<Integer> list = new ArrayList<>();
            while (!dequeue.isEmpty()) {
                if (left == 1) {
                    node = dequeue.poll();
                    list.add(node.val);
                    cur--;
                    if (node.left != null) {
                        dequeue.offer(node.left);
                        next++;
                    }
                    if (node.right != null) {
                        dequeue.offer(node.right);
                        next++;
                    }
                    if (cur == 0) {
                        ret.add(new ArrayList(list));
                        list.clear();
                        left *= -1;
                        cur = next;
                        next = 0;
                    }
                } else {
                    node = dequeue.pollLast();
                    list.add(node.val);
                    cur--;
                    if (node.right != null) {
                        dequeue.offerFirst(node.right);
                        next++;
                    }
                    if (node.left != null) {
                        dequeue.offerFirst(node.left);
                        next++;
                    }
                    if (cur == 0) {
                        ret.add(new ArrayList(list));
                        list.clear();
                        left *= -1;
                        cur = next;
                        next = 0;
                    }
                }
            }
        }
        return ret;
    }

}