import java.util.ArrayList;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        if (root != null) {
            dfs(root, target, ret, cur);
        }
        return ret;
    }
    public void dfs(TreeNode root, int target, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> cur) {
        cur.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            ret.add(new ArrayList<>(cur));
        } else {
            if (root.left != null) {
                dfs(root.left, target, ret, cur);
            }
            if (root.right != null) {
                dfs(root.right, target, ret, cur);
            }
        }
        cur.remove(cur.size() - 1);
    }
}