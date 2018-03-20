public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        int x = 1;
        int rest = n;
        do {
            int cur = rest % 10;
            rest /= 10;
            if (cur > 1) {
                count += (rest + 1) * x;
            } else if (cur == 0) {
                count += rest * x;
            } else {
                count += rest * x + n % x + 1;
            }
            x *= 10;
        } while (rest > 0);
        return count;
    }
}
/*
       

*/