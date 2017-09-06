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
    void print(TreeNode root, List<List<String>> ret, int row, int left, int right, int deep, int width) {
        if (row <= deep && left >= 0 && right <= width) {
            ret.get(row).set((left + right) / 2, "" + root.val);
            int cur  = deep - row;
            int total = (int)Math.pow(2, cur) - 1;
            if (root.left != null) {
                int leftNext = (left + right) / 2  - total;
                int rightNext = (left + right) / 2 - 1;
                print(root.left, ret, row + 1, leftNext, rightNext, deep, width);
            }
            if (root.right != null) {
                int leftNext = (left + right) / 2 + 1;
                int rightNext = (left + right) / 2 + total;
                print(root.right, ret, row + 1, leftNext, rightNext, deep, width);
            }
        }
    }
    int findHeight(TreeNode root, int height) {
        if (root == null) {
            return height;
        }
        height++;
        return Math.max(findHeight(root.left, height), findHeight(root.right, height));
        
    }
    public List<List<String>> printTree(TreeNode root) {
        int row = findHeight(root, 0);
        int col = (int)Math.pow(2, row) - 1;
        List<List<String>> ret = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                cur.add("");
            }
            ret.add(cur);
        }
        print(root, ret, 0, 0, col - 1, row - 1, col -1);
        return ret;
    }
}