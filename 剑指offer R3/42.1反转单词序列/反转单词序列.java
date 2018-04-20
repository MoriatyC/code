public class Solution {
    public String ReverseSentence(String str) {
        char[] arr = str.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == ' ') {
                reverse(arr, i, j - 1);
                i = j + 1;
            }
            if (j == arr.length - 1) {
                reverse(arr, i, j);
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
