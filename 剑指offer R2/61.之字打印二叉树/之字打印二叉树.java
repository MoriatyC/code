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
		ArrayList<ArrayList<Integer> > ret = new ArrayList<ArrayList<Integer> >();
        if (root == null) {
            return ret;
        }
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        int flag = -1;
        stack1.push(root);
        TreeNode cur = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            if (flag == -1) {
                while (!stack1.isEmpty()) {
                    cur = stack1.pop();
                    list.add(cur.val);
                    if (cur.left != null) {
                        stack2.push(cur.left);
                    }
                    if (cur.right != null) {
                        stack2.push(cur.right);
                    }
                }
                ret.add(list);
                flag *= -1;
            } else {
                while (!stack2.isEmpty()) {
                    cur = stack2.pop();
                    list.add(cur.val);
                    if (cur.right != null) {
                        stack1.push(cur.right);
                    }
                    if (cur.left != null) {
                        stack1.push(cur.left);
                    }
                }
                ret.add(list);
                flag *= -1;
            }
        }
        return ret;
    }
}
/*
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
*/