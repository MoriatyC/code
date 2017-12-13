public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null) {
            return false;
        }
        int indexStr = 0;
        int indexPattern = 0;
        return matchCore(str, pattern, indexStr, indexPattern);
    }
    public boolean matchCore(char[] str, char[] pattern, int indexStr, int indexPattern) {
        if (str.length == indexStr && pattern.length == indexPattern) {
            return true;
        }
        if (str.length != indexStr && pattern.length == indexPattern) {
            return false;
        }
        if (indexPattern + 1 < pattern.length && pattern[indexPattern + 1] == '*') {
            if ((indexStr != str.length && str[indexStr] == pattern[indexPattern]) ||
                (indexStr != str.length && pattern[indexPattern] == '.')) {
                return matchCore(str, pattern, indexStr + 1, indexPattern) || 
                    matchCore(str, pattern, 1 + indexStr, 2 + indexPattern) || 
                    matchCore(str, pattern, indexStr, 2 + indexPattern);
            }
            return matchCore(str, pattern, indexStr, 2 + indexPattern);
        } else {
            if ((indexStr != str.length && str[indexStr] == pattern[indexPattern]) || (indexStr != str.length && pattern[indexPattern] == '.')) {
                return matchCore(str, pattern, ++indexStr, ++indexPattern);
            }
            return false;
        }
    }
}