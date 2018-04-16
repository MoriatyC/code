public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        int sum = 0;
        int x = 1;
        int tmp = n;
        while (n > 0) {
            int cur = n % 10;
            if (cur > 1) {
                sum += (n / 10 + 1) * x;
            } else if (cur == 0) {
                sum += (n / 10) * x;
            } else {
                sum += (n / 10) * x + tmp % x + 1;
            }
            x *= 10;
            n /= 10;
        }
        return sum;
    }
}
/*
       

*/