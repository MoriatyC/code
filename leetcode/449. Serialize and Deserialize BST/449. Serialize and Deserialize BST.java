/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
         if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode cur = list.remove(0);
            if (cur == null) {
                sb.append("s,");
                continue;
            } else {
                sb.append(cur.val + ",");
            }
            list.add(cur.left);
            list.add(cur.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         if (data.length() == 0 || data == null) {
            return null;
        }
        String[] arr = data.split(",");
        LinkedList<TreeNode> que = new LinkedList<>(); 
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        que.offer(root);
        int index = 0;
        while (!que.isEmpty()) {
            TreeNode left = null;
            TreeNode right = null;
            TreeNode cur = que.poll();
            if (cur == null) {
                continue;
            }
            if (++index < arr.length) {
                if (!arr[index].equals("s")) {
                    left = new TreeNode(Integer.valueOf(arr[index]));
                }
                que.offer(left);
            }
            if (++index < arr.length) {
                if (!arr[index].equals("s")) {
                    right = new TreeNode(Integer.valueOf(arr[index]));
                } 
                que.offer(right);
            }
            cur.left = left;
            cur.right = right;
        }
        
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));