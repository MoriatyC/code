class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ret = 0;
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        char[] arr = s.toCharArray();
        for (; j < s.length(); j++) {
            if (set.contains(arr[j])) {
                ret = Math.max(ret, j - i);
                while (arr[i] != arr[j]) {
                    set.remove(arr[i++]);
                }
                i++;
            }
            set.add(arr[j]);
        }
        return Math.max(ret, j - i);
    }
}