import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (sum < 3) {
            return ret;
        }
        int left = 1;
        int right = 2;
        ArrayList<Integer> cur = new ArrayList<>();
        cur.add(1);
        cur.add(2);
        int now = 3;
        while (left < (sum + 1) / 2) {
            if (sum == now) {
                ret.add(new ArrayList<>(cur));
                cur.remove(0);
                now -= left;
                left++;
                right++;
                now += right;
                cur.add(right);
            } else if (now > sum) {
                cur.remove(0);
                now -= left;
                left++;
            } else {
                right++;
                now += right;
                cur.add(right);
            }
        }
        return ret;
    }
}
