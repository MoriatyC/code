import java.util.*;
//比题目要求的多了个字典逆序排序
public class Permutation {
    public void permutation(String s, List<String> list, int start) {
        char[] arr = s.toCharArray();
        if (arr.length - 1 == start) {
            list.add(s);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            char tmp = arr[start];
            arr[start] = arr[i];
            arr[i] = tmp;
            String cur = new String(arr);
            permutation(cur, list, start + 1);
            tmp = arr[start];
            arr[start] = arr[i];
            arr[i] = tmp;
        }
    }
    public ArrayList<String> getPermutation(String A) {
        // write code here
        ArrayList<String> ret = new ArrayList<>();
        permutation(A, ret, 0);
        Collections.sort(ret, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        });
        
        return ret;
    }
}