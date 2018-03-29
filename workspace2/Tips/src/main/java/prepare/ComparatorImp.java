package prepare;

import java.util.Comparator;
import java.util.PriorityQueue;

/** 
* @author : Menghui Chen 
* @version ：2018年3月12日 下午3:26:59 
* @Description:
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class ComparatorImp implements Comparator<TreeNode>{
    @Override
    public int compare(TreeNode o1, TreeNode o2) {
        return o2.val - o1.val;
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(33);
        TreeNode node3 = new TreeNode(123);
        TreeNode node4 = new TreeNode(321);
        TreeNode node5 = new TreeNode(2134);
        ComparatorImp cmp = new ComparatorImp();
        PriorityQueue<TreeNode> heap = new PriorityQueue<>(cmp);
        heap.add(node1);
        heap.add(node2);
        heap.add(node3);
        heap.add(node4);
        heap.add(node5);
        while (!heap.isEmpty()) {
            System.out.println(heap.poll().val);
        }
    }
}
