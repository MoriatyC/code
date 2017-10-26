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
            helper(root, sum, list);
        }
        return ret;
    }
    public void helper(TreeNode root, int sum, List<Integer> list) {
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum){
                ret.add(new ArrayList<>(list));
        } else {
            sum -= root.val;
            if (root.left != null) {
                helper(root.left, sum, list);
            }
            if (root.right != null) {
                helper(root.right, sum, list);
            }
        }
        list.remove(list.size() - 1);
        
    }
}