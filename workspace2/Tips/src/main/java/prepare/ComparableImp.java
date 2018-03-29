package prepare;
/** 
* @author : Menghui Chen 
* @version ：2018年3月12日 下午3:34:27 
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
public class ComparableImp implements Comparable<ComparableImp>{
    int val;
    @Override
    public int compareTo(ComparableImp o1) {
        return this.val - o1.val;
    }
    public ComparableImp(int val) {
        this.val = val;
    }
    public static void main(String[] args) {
        ComparableImp a1 = new ComparableImp(1);
        ComparableImp a2 = new ComparableImp(4);
        ComparableImp a3 = new ComparableImp(2);
        ComparableImp a4 = new ComparableImp(7);
        ComparableImp a5 = new ComparableImp(11);
        
    }

}
