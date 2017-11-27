import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (sum <= 2) {
            return ret;
        }
        int left = 1;
        int last = (sum + 1) / 2;
        int right = 2;
        while (left <= last) {
                int cur = (left + right) * (right - left + 1) / 2;
                if (cur == sum) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i = left; i <= right; i++) {
                        list.add(i);
                    }
                    ret.add(list);
                    right++;
                } else if (cur < sum) {
                    right++;
                } else {
                    left++;
                }
        }
        return ret;
    }
}
}