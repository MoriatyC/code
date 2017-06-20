public class Solution {
    public String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        char[] trans = new char[2 * str.length + 5];
        int length = str.length * 2 + 1;
        int[] len = new int[length + 10];
        int max = 0;//第一个最长最长回文子串最右边的字母，偶数时代表右边那一个
        int ret = 0;
        int po = 0;
        int index = -1;
        trans[0] = '&';
        for (int i = 1; i < length; i += 2) {
            trans[i] = '%';
            trans[i + 1] = str[i / 2];
        }
        trans[length] = '%';
        trans[length + 1] = '^';
        trans[length + 2] = 0;
        for (int i = 1; i <= length; i++) {
            if (i < max) {
                len[i] = Math.min(max - i + 1, len[2 * po - i]);
            } else {
                len[i] = 1;
            }
            while (trans[i + len[i]] == trans[i - len[i]]) {
                len[i]++;
            }
            if (max < i + len[i] - 1) {
                max = i + len[i] - 1;
                po = i;
            }
            if (ret < len[i]) {
                ret = len[i];
                index = (i - 1) / 2;
            }
            ret = Math.max(ret, len[i]);
        }
        ret -= 1;
        if (ret % 2 == 1) {
            return s.substring(index - ret / 2, index + ret / 2 + 1);
        }
        return s.substring(index - ret / 2, index + ret / 2);
    }
}