public class Solution {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] arr = str.toCharArray();
        int index = 0;
        boolean positive = true;
        if (arr[0] == '+') {
            index++;
        }
        if (arr[0] == '-') {
            index++;
            positive = false;
        }
        if (str.length() == index) {
            return 0;
        }
        int ret = 0;
        for (; index < arr.length; index++) {
            if (arr[index] >= '0' && arr[index] <= '9') {
                ret *= 10;
                ret += arr[index] - '0';
            } else {
                return 0;
            }
        }
        return positive ? ret : ret * (-1);
    }
}