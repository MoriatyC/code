import java.util.LinkedList;
import java.util.ArrayList;
public class Solution {
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> ret = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0 || size > num.length) {
            return ret;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            while (!queue.isEmpty() && num[queue.get(queue.size() - 1)] <= num[i]) {
                queue.pollLast();
            }
            queue.offer(i);
        }
        ret.add(num[queue.peek()]);
        for (int i = size; i < num.length; i++) {
            while (!queue.isEmpty() && queue.peek() + size <= i ) {
                queue.poll();
            }
            while (!queue.isEmpty() && num[queue.get(queue.size() - 1)] <= num[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            ret.add(num[queue.peek()]);
        }
        return ret;
    }
}
