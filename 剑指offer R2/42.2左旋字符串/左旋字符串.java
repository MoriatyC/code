public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n <= 0) {
            return str;
        }
        int index = n % str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt((index + i) % str.length()));
        }
        return sb.toString();
    }
}
/*        if (str == null || str.length() == 0 || n < 0) {
            return str;
        }
        int len = str.length();
        n = n % str.length();
        str += str;
        return str.substring(n, n + len);*/