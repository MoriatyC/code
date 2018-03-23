import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       ArrayList<ArrayList<Integer> > ret = new ArrayList<ArrayList<Integer> >();
        int fast = 2;
        int slow = 1;
        int cur = 3;
        while (slow < (sum + 1) / 2) {
            if (sum == cur) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = slow; i <= fast; i++) {
                    tmp.add(i);
                }
                ret.add(tmp);
                cur -= slow;
                slow++;
            } else if (sum > cur) {
                fast++;
                cur += fast;
            } else {
                cur -= slow;
                slow++;
            }
        }
        return ret;
    }
}
/*
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
*/