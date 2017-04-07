public class Solution {
    public int findLUSlength(String a, String b) {
        int ret = -1;
        if(a.equals(b))
        {
            return ret;
        }
        else
        {
            ret = Math.max(a.length(),b.length());
        }
        return ret;
    }
}