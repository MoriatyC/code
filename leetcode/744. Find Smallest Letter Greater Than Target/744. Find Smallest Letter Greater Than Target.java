class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters == null || letters.length <= 1) {
            return letters[0];
        }
        int left = 0;
        int right = letters.length - 1; 
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (target < letters[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (letters[left] > target) {
            return letters[left];
        }
        if (letters[right] > target) {
            return letters[right];
        }
        return letters[0];
    }
}