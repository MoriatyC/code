import java.util.*;

public class Solution {
    public String PrintMinNumber(int [] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        } 
       PriorityQueue pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return (s1 + s2).compareTo(s2 + s1);
            }
        });
         for (int i: nums) {
             pq.offer(i);
         }
         StringBuilder sb = new StringBuilder();
         while (!pq.isEmpty()) {
             sb.append(pq.poll());
         }
         return sb.toString();
    }
}