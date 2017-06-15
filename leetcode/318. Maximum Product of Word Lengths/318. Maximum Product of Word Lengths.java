public class Solution {
    public int maxProduct(String[] words) {
        int count = 0;
        int[] values = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c: words[i].toCharArray()) {
                values[i] |= 1 << (c - 'a');
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((values[i] & values[j]) == 0 && words[i].length() * words[j].length() > count) {
                    count = words[i].length() * words[j].length();
                }
            }
        }
        return count;
    }
}
