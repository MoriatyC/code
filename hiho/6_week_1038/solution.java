import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//奖品个数
        int m = sc.nextInt();//奖券数
        int[] need = new int[n + 5];//需要奖券 
        int[] value = new int[n + 5];
        int[] best = new int[m + 5];
        for (int i = 1; i <= n; i++) {
            need[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= need[i]; j--) {
                best[j] = Math.max(best[j - need[i]] + value[i], best[j]);
            }
        }
        System.out.println(best[m]);
    }
}