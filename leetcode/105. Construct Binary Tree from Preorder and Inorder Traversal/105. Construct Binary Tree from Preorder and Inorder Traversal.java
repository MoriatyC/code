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
    TreeNode build(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {//pre首地址，末地址，in首地址，末地址
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        if (pre == null || pre.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int sep = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                sep = i;
                break;
            }
        }
        int inS1 = inStart;
        int inE1 = sep - 1;
        int preS1 = preStart + 1;
        int preE1 = preS1 + inE1 -inS1;
        
        int preS2 = preE1 + 1;
        int preE2 = preEnd;
        int inS2 = sep + 1;
        int inE2 = inEnd;
        root.left = build(pre, in, preS1, preE1, inS1, inE1);
        root.right = build(pre, in, preS2, preE2, inS2, inE2);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null|| preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
}