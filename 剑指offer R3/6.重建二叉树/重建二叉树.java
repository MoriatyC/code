/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return helper(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
    public TreeNode helper(int[] pre, int s1, int e1, int[] in, int s2, int e2) {
        if (s1 > e1) {
            return null;
        }
        TreeNode root = new TreeNode(pre[s1]);
        int index = s2;
        for (; index <= e2; index++) {
            if (in[index] == pre[s1]) {
                break;
            }
        }
        root.left = helper(pre, s1 + 1, s1 + index - s2, in, s2, index - 1);
        root.right = helper(pre, s1 + index - s2 + 1, e1, in, index + 1, e2);
        return root;
    }
}


