import java.util.*;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] arr = new int[128];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        char[] arrChar = str.toCharArray();
        for (int i = 0; i < arrChar.length; i++) {
            if (arr[arrChar[i]] == -1) {
                arr[arrChar[i]] = i;
            } else if (arr[arrChar[i]] >= 0) {
                arr[arrChar[i]] = -2;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arrChar.length; i++) {
            if (arr[arrChar[i]] < min && arr[arrChar[i]] > -1) {
                min = arr[arrChar[i]];
            }
        }
        return min;
    }
}