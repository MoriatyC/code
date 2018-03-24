public class Solution {
    public int Add(int num1,int num2) {
        int in = 0;
        int carry = 1;
        while (carry != 0) {
            in = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = in;
            num2 = carry;
        }
        return in;
    }
}