import java.util.*;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        backtracking(arr, 0, sb, set);
        ArrayList<String> ret = new ArrayList<String>(set);
        Collections.sort(ret);
        return ret;
    }
    public void backtracking(char[] arr, int index, StringBuilder sb, Set<String> ret) {
        if (arr.length == index) {
            ret.add(sb.toString());
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            sb.append(arr[index]);
            backtracking(arr, index + 1, sb, ret);
            sb.deleteCharAt(sb.length() - 1);
            swap(arr, index, i);
        }
    }
    public void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
