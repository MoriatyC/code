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
	//post
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                list.push(root.val);
                root = root.right;
            } else {
                root = stack.pop();
                root = root.left;
            }
        }
        
        return list;
    }
	//pre
	public List<Integer> preoderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                list.offer(root.val);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        
        return list;
    }
	
	public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.right;
            } else {				
                root = stack.pop();
				list.offer(root.val);
                root = root.right;
            }
        }
        
        return list;
    }
}
