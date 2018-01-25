public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n < 0) {
            return str;
        }
        int len = str.length();
        n = n % str.length();
        str += str;
        return str.substring(n, n + len);
    }
	public boolean LeftRotateString(String str,String b) {
        if (str == null || str.length() == 0 || b == null || b.length() == 0) {
            return str;
        }
        str += str;
        return str.contains(b);
    }
}