public class Solution {
    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] arr = str.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int left = 0;
        int right = 0;
        while (left != arr.length) {
            if (arr[right] != ' ' && right != arr.length - 1) {
                right++;
            } else {
                if (right == arr.length - 1) {
                     reverse(arr, left, right);
                } else {
                     reverse(arr, left, right - 1);
                }
                right++;
                left = right;
            }
        }
        return new String(arr);
    }
}