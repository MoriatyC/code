public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0) {
            return str;
        }
        n %= str.length();
        String s1 = str.substring(0, n);
        String s2 = str.substring(n);
        return s2 + s1;
    }
}
