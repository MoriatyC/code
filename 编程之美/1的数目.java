public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n == 1) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }
    	int ret = 0;
        int rightNum = 0;
        int factor = 1;
        while (n > 0) {
            int cur = n % 10;
            n /= 10;
            if (n == 0) {
                if (cur > 1) {
                    ret += factor;
                } else {
                    ret += rightNum + 1;
                }
            } else {
                if (cur > 1) {
                    ret += (n + 1) * factor;
                } else if (cur == 1) {
                    if (factor == 1) {
                        ret += (n + 1) * factor;
                    } else {
                        ret += n * factor + rightNum + 1;
                    }

                } else {
                    ret += n * factor;
                }
                rightNum += factor * cur;
                factor *= 10;
            }
            
        }
        return ret;
    }
}