import java.util.*;
public class Solution {
    PriorityQueue<Integer> small = new PriorityQueue<>();
    PriorityQueue<Integer> big = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public void Insert(Integer num) {
        if (big.size() == small.size()) {
            small.offer(num);
            int head = small.poll();
            big.offer(head);
        } else {
            big.offer(num);
            int head = big.poll();
            small.offer(head);
        }
    }

    public Double GetMedian() {
        if (small.size() == big.size()) {
            return (small.peek() + big.peek()) / 2.0;
        }
        return Double.valueOf(big.peek());
    }


}