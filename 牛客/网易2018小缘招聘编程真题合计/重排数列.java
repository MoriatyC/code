import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = {0, 0, 0};
            for (int i = 0; i < n; i++) {
                int cur = sc.nextInt();
                if (cur % 4 == 0) {
                    arr[0]++;
                } else if (cur % 2 == 0) {
                    arr[2]++;
                } else {
                    arr[1]++;
                }
            }
            if (arr[0] >= arr[1]) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
         
        sc.close();
    }
}