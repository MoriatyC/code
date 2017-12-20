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
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
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
    }
    
}