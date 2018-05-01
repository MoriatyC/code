import java.util.*;
public class Solution {
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public void Insert(Integer num) {
        if (min.size() == max.size()) {
            if (min.size() == 0) {
                max.offer(num);
            } else {
                min.offer(num);
                int tmp = min.poll();
                max.offer(tmp);
            }
        } else {
            max.offer(num);
            int tmp = max.poll();
            min.offer(tmp);
        }
    }

    public Double GetMedian() {
        if (min.size() == max.size()) {
            return (min.peek() + max.peek()) / 2.0;
        }
        return Double.valueOf(max.peek());
    }


}