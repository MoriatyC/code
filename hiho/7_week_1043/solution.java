import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//½±Æ· 
        int m = sc.nextInt();//½±È¯ 
        int[] need = new int[n + 5];
        int[] value = new int[n + 5];
        int[][] best = new int[2][m + 5];
        for (int i = 1; i <= n; i++) {
            need[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if(i % 2 == 1) {
                    if (j < need[i]) {
                        best[0][j] = best[1][j];
                    } else {
                        best[0][j] = Math.max(best[1][j], best[0][j - need[i]] + value[i]);
                    }
                    
                } else {
                    if (j < need[i]) {
                        best[1][j] = best[0][j];
                    } else {
                        best[1][j] = Math.max(best[0][j], best[1][j - need[i]] + value[i]);
                    }
                }
                
            }
        }
        System.out.println(Math.max(best[1][m], best[0][m]));
    }
}