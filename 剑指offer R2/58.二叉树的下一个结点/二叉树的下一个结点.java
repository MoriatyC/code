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
        TreeLinkNode ret = null;
        if (pNode == null) {
            return ret;
        }
        if (pNode.right != null) {
            //右子树不为空，找右子树最左点
            ret = pNode.right;
            while (ret.left != null) {
                ret = ret.left;
            }
        } else if (pNode.next != null) {
            //右子树为空，如果是左子节点，返回父节点，否则找第一个父节点他是父父节点的左结点，要一直注意father可能为null
            TreeLinkNode cur = pNode;
            TreeLinkNode father = cur.next;
            while (father != null && father.left != cur) {
                cur = father;
                father = father.next;
            }
            ret = father;
        }
        return ret;
    }
    
}