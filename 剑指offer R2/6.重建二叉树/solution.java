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
        if (pre.length != in.length) {
            return null;
        }
        return build(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
    public TreeNode build(int[] pre, int s1, int e1, int[] in, int s2, int e2) {
        if (s1 > e1 ) {
            return null;
        }
        TreeNode root = new TreeNode(pre[s1]);
        int i = s2;
        for (; i <= e2; i++) {
            if (pre[s1] == in[i]) {
                break;
            }
        }
        root.left = build(pre, s1 + 1, i - s2 + s1, in, s2, i - 1);
        root.right = build(pre, i - s2 + s1 + 1, e1, in ,i + 1, e2);
        return root;
    }
}