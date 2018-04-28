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
import java.util.LinkedList;
public class Solution {
    String Serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> tmp = new LinkedList<>();
        tmp.offer(root);
        while (!tmp.isEmpty()) {
            TreeNode cur = tmp.poll();
            if (cur != null) {
                sb.append(cur.val).append(" ");
                if (cur.left != null) {
                    tmp.offer(cur.left);
                } else {
                    tmp.offer(null);
                }
                if (cur.right != null) {
                    tmp.offer(cur.right);
                } else {
                    tmp.offer(null);
                }
            } else {
                sb.append("# ");
            }
        }
        return sb.toString().trim();
  }
    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] arr = str.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        int index = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (!arr[index].equals("#")) {
                TreeNode left = new TreeNode(Integer.valueOf(arr[index++]));
                cur.left = left;
                queue.offer(left);
            } else {
                index++;
            }
            if (!arr[index].equals("#")) {
                TreeNode right = new TreeNode(Integer.valueOf(arr[index++]));
                cur.right = right;
                queue.offer(right);
            } else {
                index++;
            }
        }
        return root;
  }
}