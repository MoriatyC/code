import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//��Ʒ����
        int m = sc.nextInt();//��ȯ��
        int[] need = new int[n + 5];//��Ҫ��ȯ 
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