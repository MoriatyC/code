public class Solution {
    public String replaceSpace(StringBuffer str) {
    	if (str == null || str.length() == 0) {
            return str.toString();
        }
        char[] arr = str.toString().toCharArray();
        int count = 0;
        for (char c: arr) {
            if (c == ' ') {
                count++;
            }
        }
        char[] ret = new char[arr.length + count * 2];
        int index1 = arr.length - 1;
        int index2 = ret.length - 1;
        for (; index1 >= 0; index1--) {
            if (arr[index1] != ' ') {
                ret[index2--] = arr[index1];
            } else {
                ret[index2--] = '0';
                ret[index2--] = '2';
                ret[index2--] = '%';
            }
        }
        return new String(ret);
    }
}