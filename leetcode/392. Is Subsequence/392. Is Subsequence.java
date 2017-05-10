public class Solution {
    public boolean isSubsequence(String s, String t) {
        int leng = s.length();
        if (leng == 0) {
            return true;
        }
        int index = 0;
        for (char c : t.toCharArray()) {
            if (c == s.charAt(index)) {
                index++;
                if (index == leng) {
                    return true;
                }
            }
        }
        return false;
    }
}