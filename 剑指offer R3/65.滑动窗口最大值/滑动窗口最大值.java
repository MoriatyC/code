import java.util.*;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> ret = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        if (num == null || num.length < size || size == 0) {
            return ret;
        }
        for (int i = 0; i < size; i++) {
            while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
                queue.pollLast();
            }
            queue.offer(i);
        }
        ret.add(num[queue.peek()]);
        for (int i = size; i < num.length; i++) {
            if (!queue.isEmpty() && (queue.peek() + size == i)) {
                queue.poll();
            }
            while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            ret.add(num[queue.peek()]);
        }
        return ret;
    }
}