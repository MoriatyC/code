import java.util.Scanner;
 
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if (s == null | s.length() == 0) {
            System.out.println(0);
            return;
        }
        char[] arr = s.toCharArray();
        int ret = 0;
        int tempCount = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                tempCount++;
            } else {
                ret = Math.max(ret, tempCount);
                tempCount = 1;
            }
        }
        System.out.println(Math.max(ret, tempCount));
    }
}