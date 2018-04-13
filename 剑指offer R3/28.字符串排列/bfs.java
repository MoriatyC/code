import java.util.*;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> ret = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return ret;
        }
        char[] arr = str.toCharArray();
        ArrayList<ArrayList<Integer>> tmp = new ArrayList<>();
        LinkedList<ArrayList<Integer>> queue = new LinkedList<>();
        queue.offer(new ArrayList<Integer>());
        while (!queue.isEmpty()) {
            ArrayList<Integer> cur = queue.poll();
            if (cur.size() == str.length()) {
                tmp.add(cur);
            } else {
                for (int i = 0; i < arr.length; i++) {
                    if (!cur.contains(i)) {
                        cur.add(i);
                        queue.offer(new ArrayList<Integer>(cur));
                        cur.remove(cur.size() - 1);
                    }
                }
            }
        }
        ret = transfer(tmp, arr);
        Collections.sort(ret);
        return ret;
    }
    public ArrayList<String> transfer(ArrayList<ArrayList<Integer>> tmp, char[] arr) {
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for (ArrayList<Integer> list: tmp) {
            for (Integer i: list) {
                sb.append(arr[i]);
            }
            set.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return new ArrayList<String>(set);
    }
}
