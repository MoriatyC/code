public class Solution {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0 || str.trim().length() == 0) {
            return 0;
        }
        char[] arr = str.trim().toCharArray();
        boolean positive = true;
        int index = 0;
        long sum = 0;
        if (arr[0] == '-') {
            positive = false;
            index++;
        } else if (arr[0] == '+') {
            index++;
        }
        if (index == arr.length) {
            return 0;
        } else {
            sum = arr[index++] - '0';
        }
        for (; index < arr.length; index++) {
            if (arr[index] < '0' || arr[index] > '9') {
                System.out.println("check intput");
                return 0;
            }
            sum = sum * 10 + arr[index] - '0';
        }
        sum = positive ? sum : sum * -1;
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            System.out.println("check intput");
            return 0;
        }
        return (int)sum;
    }
}