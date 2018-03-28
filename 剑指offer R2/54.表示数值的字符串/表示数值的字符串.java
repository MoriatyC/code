public class Solution {
      int index = 0;
    public   boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        if (str[index] == '+' || str[index] == '-') {
            index++;
        }
        if (index == str.length) {
            return false;
        }
        boolean flag = true;
        scanDigits(str);
        if (index != str.length) {
            if (str[index] == '.') {
                index++;
                scanDigits(str);
          
                if (str.length > index && (str[index] == 'e' || str[index] == 'E')) {
                    flag = dealE(str);
                }
            } else if (str[index] == 'e' || str[index] == 'E') {
                    flag = dealE(str);
            } else {
                flag = false;
            }
        }
        return flag && index == str.length;
   }
   public  void scanDigits(char[] str) {
       while (index != str.length && str[index] >= '0' && str[index] <= '9') {
           index++;
       }
   }
   public  boolean dealE(char[] str) {
       index++;
       if (index == str.length) {
           return false;
       }
       if (str[index] == '+' || str[index] == '-') {
           index++;
       }
       if (index == str.length) {
           return false;
       }
       scanDigits(str);
       if (str.length == index) {
           return true;
       }
       return false;
   }
}
