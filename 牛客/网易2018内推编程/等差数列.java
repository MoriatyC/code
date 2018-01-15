import java.util.Scanner;
import java.util.Arrays;
 
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        if (len <= 1) {
            System.out.println("Impossible");
            return;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2 ; i < len; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }
}