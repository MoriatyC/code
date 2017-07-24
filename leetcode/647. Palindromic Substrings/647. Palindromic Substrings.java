public class Solution {
    public int countSubstrings(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        int count = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            count++;
            count += search(arr, i - 1, i + 1);
            count += search(arr, i, i + 1);
        }
        return count;
    }
    
    int search(char[] s, int left, int right) {
        int ret = 0;
        while (left >= 0 && right <= s.length - 1 && s[left--] == s[right++]) {
            ret++;
        }
        return ret;
    }

}