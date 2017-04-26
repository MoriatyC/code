public class Solution {
    int cal(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10) * (num % 10);
            num /= 10;
        }
        return sum;
    }

    boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = cal(slow);
            fast = cal(fast);
            fast = cal(fast);
            if (fast == 1) {
                return true;
            }
        } while(fast != slow);
        return false;
    }
        
}
