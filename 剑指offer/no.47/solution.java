public class Solution {
    public int Add(int num1,int num2) {
        int sum;
        do {
            sum = num1 ^ num2;
            num2 = num1 & num2;
            num2 = num2 << 1;
            num1 = sum;
        } while (num2 != 0);
        return sum;
    }
}