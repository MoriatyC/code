public class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> list = new ArrayList();
        for(String time: timePoints)
        {
            String[] cur = time.split(":");
            list.add(Integer.valueOf(cur[0]) * 60 + Integer.valueOf(cur[1]));
        }
        int min = Integer.MAX_VALUE;
        Collections.sort(list);
        for(int i = 0; i < list.size() - 1; i++)
        {
            int curTime = list.get(i+1) - list.get(i);
            min = min < curTime ? min : curTime;
        }
        int x = 1440 - list.get(list.size() - 1) + list.get(0);
        min = min < x ? min : x;
        return min;
    }
}