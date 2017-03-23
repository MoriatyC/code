public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n <= 0) return 1;
        if(n == 1) return 10;
        int ret = 10;
        int mul = 9;
        int index = 9;
        while(index + n >= 11)
        {
            mul *= index;
            ret += mul;
            index--;
        }
        
        return ret;
    }
}