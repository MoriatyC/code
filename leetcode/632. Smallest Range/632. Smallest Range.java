public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(nums.size(), (i, j) -> i[0] - j[0]);
        
        int left = -100000;
        int right = 100000;
        int max = nums.get(0).get(0);
        int[] cur;
        boolean flag = true;
        
        for (int i = 0; i < nums.size(); i++) {
            queue.offer(new int[]{nums.get(i).get(0), i, 0});//存储的三个值分别为当前最小值， 所属list的index， 当前最小值在list中的index
            max = Math.max(max, nums.get(i).get(0));
        }//找出初始状态下的最小值
       
        while (flag) {
            cur = queue.poll();
            if (max - cur[0] < right - left) {
                left = cur[0];
                right = max;
            } 
            if ( ++cur[2] < nums.get(cur[1]).size()) {
                cur[0] = nums.get(cur[1]).get(cur[2]);
                max = Math.max(max, cur[0]);
                queue.offer(cur);
            } else {
                flag = false;
            }
        }
        return new int[]{left, right};
    }
}