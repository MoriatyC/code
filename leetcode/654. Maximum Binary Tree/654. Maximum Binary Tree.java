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
    TreeNode build(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                index = i;
                max = nums[i];
            }
        }    
        TreeNode node = new TreeNode(max);
        if (index > left) {
            node.left = build(nums, left, index - 1);
        }
        if (index < right) {
            node.right = build(nums, index + 1, right);
        }
        return node;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
}
}