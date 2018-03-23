public class Solution {
    public String ReverseSentence(String str) {
       if (str == null || str.length() == 0) {
           return str;
       }
        char[] arr = str.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int start = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ' ') {
                reverse(arr, start, i - 1);
                start = i + 1;
            }
            if (i == arr.length - 1) {
                reverse(arr, start, i);
            }
        }
        return new String(arr);
    }
    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left++, right--);
        }
    }
    public void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
