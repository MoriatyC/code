import java.util.*;
public class Solution {
    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        int count = 0;
        int length = str.length();
        int index = length - 1;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        int newLength = length + 2 * count;
        str.setLength(newLength);
        for (int i = newLength - 1; index >= 0 && i != index; i--, index--) {
            if (str.charAt(index) == ' ') {
                str.setCharAt(i--, '0');
                str.setCharAt(i--, '2');
                str.setCharAt(i, '%');
            } else {
                str.setCharAt(i, str.charAt(index));
            }
        }
        return str.toString();
    }
}