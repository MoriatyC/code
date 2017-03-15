public class Solution {
    public String convertToBase7(int num) {
        if(num == 0)
            return "0";
        StringBuffer sb = new StringBuffer();
        boolean flag = false;
        if(num < 0)
        {
            flag = true;
            num *= -1;
        }
        while(num > 0)
        {
            sb.append(num % 7);
            num /= 7;
        }
        if(flag)
        {
            sb.append("-");
        }
        sb.reverse();
        return sb.toString();
    }
}