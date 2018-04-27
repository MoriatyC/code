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
            return pNode;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
        } else {
            TreeLinkNode father = pNode.next;
            if (father == null || father.left == pNode) {
                pNode = father;
            } else {
                while (father != null && father.left != pNode) {
                    pNode = father;
                    father = father.next;
                }
                pNode = father;
            }
        }
        return pNode;
    }
    
}