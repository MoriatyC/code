import java.util.LinkedList;
import java.util.ArrayList;
public class Solution {
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if (num == null || num.length == 0 || num.length < size || size <= 0) {
            return new ArrayList<Integer>();
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            while (!queue.isEmpty() && num[i] >= num[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
        }
        ArrayList<Integer> ret = new ArrayList<>();
        ret.add(num[queue.peek()]);
        for (int i = size; i < num.length; i++) {
            if (num[i] < num[queue.peekLast()]) {
                queue.offer(i);
            } else {
                while (!queue.isEmpty() && num[i] >= num[queue.peekLast()]) {
                    queue.pollLast();
                }
                queue.offer(i);
            }
            if (i - queue.peek() >= size) {
                queue.poll();
            }
            ret.add(num[queue.peek()]);
        }
        return ret;
    }
}