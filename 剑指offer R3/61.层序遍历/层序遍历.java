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
        ArrayList<ArrayList<Integer> > ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            if (!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    TreeNode cur = queue1.poll();
                    tmp.add(cur.val);
                    if (cur.left != null) {
                        queue2.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue2.offer(cur.right);
                    }
                }
                ret.add(tmp);
            } else {
                while (!queue2.isEmpty()) {
                    TreeNode cur = queue2.poll();
                    tmp.add(cur.val);
                    if (cur.left != null) {
                        queue1.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue1.offer(cur.right);
                    }
                }
                ret.add(tmp);
            }
        }
        return ret;
    }
    
}

/*
ArrayList<ArrayList<Integer> > ret = new ArrayList<>();
        if (pRoot != null) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(pRoot);
            TreeNode cur;
            ArrayList<Integer> list = new ArrayList<>();
            int curlevel = 1;
            int nextlevel = 0;
            while (!queue.isEmpty()) {
                cur = queue.poll();
                list.add(cur.val);
                curlevel--;
                if (cur.left != null) {
                    queue.add(cur.left);
                    nextlevel++;
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    nextlevel++;
                }
                if (curlevel == 0) {
                    ret.add(new ArrayList(list));
                    list.clear();
                    curlevel = nextlevel;
                    nextlevel = 0;
                }
            }
        }
        return ret;
*/