/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size;
        double sum;
        TreeNode cur;
        while (!queue.isEmpty()) {
            size = queue.size();
            sum = 0.0;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            ret.add(1.0 * sum / size);
        }
        return ret;
    }
}