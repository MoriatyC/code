public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        s = s.trim();
        String[] arr = s.split("\\s+");
        int i  = 0;
        int j = arr.length - 1;
        while (i < j) {
            String tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}