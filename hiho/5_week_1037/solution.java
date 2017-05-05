import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// ²ãÊı 
  
        int[][] arr = new int[n + 5][];
        int[] best = new int[n + 5];
        for (int i = 1; i <= n; i++) {
            arr[i] = new int[i + 1];
            for (int j = 1; j <= i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        best[1] = arr[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                best[j] = Math.max(best[j] , best[j - 1]) + arr[i][j];
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, best[i]);
        }
        System.out.println(max);
        
    }
}