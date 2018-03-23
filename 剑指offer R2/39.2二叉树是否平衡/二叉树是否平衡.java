public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return postOrder(root, new int[]{0});
    }
    public boolean postOrder(TreeNode root, int[] deep) {
        if (root == null) {
            deep[0] = 0;
            return true;
        }
        int[] left = {0};
        int[] right = {0};
        if (postOrder(root.left, left) && postOrder(root.right, right)) {
            if (left[0] - right[0] <= 1 && right[0] - left[0] <= 1) {
                deep[0] = Math.max(left[0], right[0]) + 1;
                return true;
            }
        }
        return false;
    }
}