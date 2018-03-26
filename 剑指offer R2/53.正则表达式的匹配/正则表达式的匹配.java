public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern, 0, 0);
        
        
    }
    public boolean matchCore(char[] str, char[] pattern, int s1, int s2) {
        //由于可能出现str已经结束了但是模式没有结束的情况所以要时刻检查str
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (str.length == s1 && pattern.length == s2) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (str.length != s1 && pattern.length == s2) {
            return false;
        }
        if (s2 + 1 < pattern.length && pattern[s2 + 1] == '*') {
            if (s1 != str.length && (pattern[s2] == str[s1] || pattern[s2] == '.')) {
                //消耗当前*
                return matchCore(str, pattern, s1 + 1, s2 + 2) ||
                    //继续使用*
                    matchCore(str, pattern, s1 + 1, s2) || 
                    //忽略使用*
                    matchCore(str, pattern, s1, s2 + 2);
            } else {
                return matchCore(str, pattern, s1, s2 + 2);
            }
        }
        if (str.length != s1 && (pattern[s2] == '.' || pattern[s2] == str[s1])) {
            return matchCore(str, pattern, s1 + 1, s2 + 1);
        }
        return false;
    }
}
    
