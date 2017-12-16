public class Solution {
     public  boolean isNumeric(char[] str) {
         String s = String.valueOf(str);
        return s.matches("[\\+-]?\\d*\\.?\\d+([eE][+-]?\\d+)?");
    }
}