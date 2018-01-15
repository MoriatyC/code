import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        if (len % 2 == 0) {
            int half = len / 2;
            for (int i = half; i > 0; i--) {
                sb.append(arr[i * 2 - 1]).append(" ");
            }
            for (int i = 0; i < half; i++) {
                sb.append(arr[i * 2]).append(" ");
            }
        } else {
            int half = len / 2;
            for (int i = half; i >= 0; i--) {
                sb.append(arr[i * 2]).append(" ");
            }
            for (int i = 1; i <= half; i++) {
                sb.append(arr[i * 2 - 1]).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}