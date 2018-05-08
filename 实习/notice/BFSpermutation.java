import java.util.*;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<String>();
        }
        LinkedList<ArrayList<Integer>> queue = new LinkedList<>();
        queue.offer(new ArrayList<Integer>());
        Set<String> ret = new HashSet<>();
        while (!queue.isEmpty()) {
            ArrayList<Integer> cur = queue.poll();
            if (cur.size() == str.length()) {
                ret.add(transfer(cur, str));
            } else {
                for (int i = 0; i < str.length(); i++) {
                    if (!cur.contains(i)) {
                        cur.add(i);
                        queue.offer(new ArrayList<Integer>(cur));
                        cur.remove(cur.size() - 1);
                    }
                }
            }
        }
        ArrayList<String> list = new ArrayList<>(ret);
        Collections.sort(list);
        return list;
    }
    public String transfer(ArrayList<Integer> list, String str) {
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        for (int i: list) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
