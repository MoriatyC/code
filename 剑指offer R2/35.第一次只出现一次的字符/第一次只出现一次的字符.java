import java.util.*;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] map = new int[256];
        char[] arr = str.toCharArray();
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (map[arr[i]] == -1) {
                map[arr[i]] = i;
            } else if (map[arr[i]] >= 0) {
                map[arr[i]] = -2;
            }
        }
        int ret = Integer.MAX_VALUE;
        for (int i: map) {
            if (i >= 0) {
                ret = Math.min(ret, i);
            }
        }
        return ret;
    }
}