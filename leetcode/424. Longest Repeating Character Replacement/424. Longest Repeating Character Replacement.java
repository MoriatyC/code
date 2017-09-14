class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int start = 0;
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        for (int end = 0; end < s.length(); end++) {
            max = Math.max(max, ++count[arr[end] - 'A']);
            if (end - start + 1 - max > k) {
                count[arr[start++] - 'A']--;
            }
        }
        return s.length() - start;
    }
}