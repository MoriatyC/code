public class Solution {
    public String findLongestWord(String s, List<String> d) {
        if (s.length() == 0 || s == null || d.size() == 0 || d == null) {
            return "";
        }
        char[] target = s.toCharArray();
        boolean fair;
        String ret = "";
        for (String word: d) {
            char[] arr = word.toCharArray();
            int sleft = 0;
            int left = 0;
            fair = false;
            while (true) {
                while (arr[sleft] != target[left]) {
                    left++;
                    if (left == target.length) {
                        fair = true;
                        break;
                    }
                }
                if (!fair) {
                    left++;
                    sleft++;
                } else {
                    break;
                }
                if (sleft == arr.length) {
                    if (ret.length() < word.length() || (ret.length() == word.length() && word.compareTo(ret) < 0)) {
                        ret = word;
                    }
                    break;
                } else if(left == target.length) {
                    break;
                }
            }
        }
        return ret;
    }
}