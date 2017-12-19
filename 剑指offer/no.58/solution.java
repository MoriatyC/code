/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
} 
*/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        if (pNode.next == null || pNode == pNode.next.left) {
            return pNode.next;
        }
        pNode = pNode.next;
        while (pNode.next != null) {
            if (pNode == pNode.next.left) {
                break;
            }
            pNode = pNode.next;
        }
        return pNode.next;
    }
}