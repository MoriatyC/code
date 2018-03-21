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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        List<TreeNode> ret1 = findPath(root, p, list1);
        List<TreeNode> ret2 = findPath(root, q, list2);
       
        int index = 0;
        while (index < ret1.size() && index < ret2.size() && ret1.get(index) == ret2.get(index)) {
            index++;
        }
        return ret1.get(index - 1);
    }
    public List<TreeNode> findPath(TreeNode root, TreeNode p, List<TreeNode> list) {
        if (root == p) {
            list.add(root);
            return new ArrayList<>(list);
        }
        List<TreeNode> left = null;
        List<TreeNode> right = null;
        list.add(root);
        if (root.left != null) {
            left = findPath(root.left, p, list);
        }
        if (root.right != null) {
            right = findPath(root.right, p, list);
        }
        list.remove(list.size() - 1);
        return left == null ? right : left;
    }
}