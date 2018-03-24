import java.util.LinkedList;
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int cur = 0;
        while (list.size() > 1) {
            cur = (cur + m - 1) % list.size();
            list.remove(cur);
        }
        return list.get(0);
    }
}
