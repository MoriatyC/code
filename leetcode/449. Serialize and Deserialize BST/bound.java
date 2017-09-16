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
        return null;
    }
    StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.toString();
}

private void serialize(TreeNode root, StringBuilder sb) {
    if (root == null) {
        return;
    }
    sb.append(root.val).append(" ");
    serialize(root.left, sb);
    serialize(root.right, sb);
}

// Decodes your encoded data to tree.
public TreeNode deserialize(String data) {
    if (data == null || data.length() == 0) {
        return null;
    }
    String[] nodes = data.split(" ");
    int[] index = new int[] {0};
    return deserialize(nodes, index, Integer.MAX_VALUE);
}

private TreeNode deserialize(String[] nodes, int[] index, int max) {
    if (index[0] >= nodes.length || Integer.valueOf(nodes[index[0]]) >= max) {
        return null;
    }
    TreeNode root = new TreeNode(Integer.valueOf(nodes[index[0]++]));
    root.left = deserialize(nodes, index, root.val);
    root.right = deserialize(nodes, index, max);
    return root;
}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));