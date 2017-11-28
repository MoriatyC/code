public class Solution {
    public  void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n < 0) {
            return str;
        }
        char[] arr = str.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int right = str.length() - n;
        reverse(arr, 0, right - 1);
        reverse(arr, right, arr.length - 1);
        return new String(arr);
    }
}