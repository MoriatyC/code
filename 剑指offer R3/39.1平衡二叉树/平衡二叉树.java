public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return IsBalanced_Solution(root, new int[]{0});
    }
    public boolean IsBalanced_Solution(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }
        int[] left = {0};
        int[] right = {0};
        if (IsBalanced_Solution(root.left, left) && IsBalanced_Solution(root.right, right)) {
            if (Math.abs(left[0] - right[0]) <= 1) {
                depth[0] = Math.max(left[0], right[0]) + 1;
                return true;
            }
        }
        return false;
    }
}