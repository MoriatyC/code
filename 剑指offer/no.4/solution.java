package first_maven;
public class Main {  
    public static void solution(char[] string, String target) {
        if (target == null  target.length() == 0) {
            return;
        }
        int length = target.length();
        if (string == null  string.length == 0) {
            return;
        }
        int countBank = 0;
        for (int i = 0; i  length; i++) {
            if (string[i] == ' ') {
                countBank++;
            }
        }
        int newLength = length + 2  countBank;
        length--;
        newLength--;
        while (length =0 && length != newLength) {
            if (string[length] != ' ') {
                string[newLength--] = string[length--];
            } else {
                string[newLength--] = '0';
                string[newLength--] = '2';
                string[newLength--] = '%';
                length--;
            }
        }
        
    }
  static  char  c;
    public static void main(String[] args) {
        char[] string = new char[50];
        String s = null;
        String s2 = ;
        String s3 = we arehappy;
        String s4 = we are happy;
        int index = 0;
        char[] tmp = s.toCharArray();
        for (char c tmp) {
            string[index++] = c;
        }
        solution(string, s);
        System.out.println(String.valueOf(string));
    }
}