import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] ret = new String[1];
        StringBuilder sb = new StringBuilder();
       
        while (n > 0) {
            if (n % 2 == 1) {
                sb.append("1");
                n = (n - 1) / 2;
            } else {
                sb.append("2");
                n = (n - 2) / 2;
            }
        }
        System.out.println(sb.reverse().toString());
        sc.close();
    }
}