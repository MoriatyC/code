import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double ret = solution(n);
        System.out.println(String.format("%.4f", ret));
    }
    public static double solution(int n) {
        double[] dp = new double[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
            dp[i] = dp[i] / (i + 1) + 1;
        }
        return dp[n - 1];
    }
}