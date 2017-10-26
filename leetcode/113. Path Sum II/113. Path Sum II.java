/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.add(root.val);
            helper(root, sum - root.val, list);
        }
        return ret;
    }
    public void helper(TreeNode root, int sum, List<Integer> list) {
        if (root.left == null && root.right == null) {
            if (0 == sum) {
                ret.add(new ArrayList<>(list));
            }
            return;
        }
        if (root.left != null) {
            list.add(root.left.val);
            helper(root.left, sum - root.left.val, list);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            list.add(root.right.val);
            helper(root.right, sum - root.right.val, list);
            list.remove(list.size() - 1);
        }
    }
}