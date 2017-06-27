public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        backstrack(ret, new ArrayList<>(), s.toCharArray(), 0, s);
        return ret;
    }
    void backstrack(List<List<String>> ret, List<String> list, char[] arr, int start, String s) {
        if (start == arr.length) {
            ret.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < arr.length; i++) {
                if (help(arr, start, i)) {
                    list.add(s.substring(start, i + 1));
                    backstrack(ret, list, arr, i + 1, s);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
    boolean help(char[] arr, int start, int end) {
        while (start < end) {
            if (arr[start++] != arr[end--]) {
                return false;
            }
        }
        return true;
    }
}