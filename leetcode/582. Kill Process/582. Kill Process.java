public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int size = pid.size();
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> ret = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        List<Integer> temp;
        int head;
        for (int i = 0; i < size; i++) {
            temp = map.getOrDefault(ppid.get(i), new ArrayList<>());
            temp.add(pid.get(i));
            map.put(ppid.get(i), temp);
        }
        que.offer(kill);
        while (!que.isEmpty()) {
            head = que.poll();
            ret.add(head);
            if (map.containsKey(head)) {
                que.addAll(map.get(head));
            }
            
        }
        return ret;
    }
}