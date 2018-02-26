class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ret = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int j = 0;
        int i = 0;
        for (; j < s.length(); j++) {
            if (map.containsKey(arr[j])) {
                ret = Math.max(ret, j - i);
                i = Math.max(i, map.get(arr[j]) + 1);
            }
            map.put(arr[j], j);
        }
        return Math.max(ret, j - i);
    }
}