/*
链接：https://www.nowcoder.com/questionTerminal/49375dd6a42d4230b0dc4ea5a2597a9b
来源：牛客网

小易非常喜欢拥有以下性质的数列:
1、数列的长度为n
2、数列中的每个数都在1到k之间(包括1和k)
3、对于位置相邻的两个数A和B(A在B前),都满足(A <= B)或(A mod B != 0)(满足其一即可)
例如,当n = 4, k = 7
那么{1,7,7,2},它的长度是4,所有数字也在1到7范围内,并且满足第三条性质,所以小易是喜欢这个数列的
但是小易不喜欢{4,4,4,2}这个数列。小易给出n和k,希望你能帮他求出有多少个是他会喜欢的数列。 
*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] dp = new int[n + 1][k + 1];
        int mod = 1000000007;
        for (int i = 1; i <= k; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= k; j++) {
                sum = (sum + dp[i - 1][j]) % mod;
            }
            for (int j = 1; j <= k; j++) {
                int p = 2;
                int invalid = 0;
                while (p * j <= k) {
                    invalid = (invalid + dp[i - 1][p * j]) % mod;
                    p++;
                }
                dp[i][j] = (sum + mod - invalid) % mod;
            }
        }
        int ret = 0;
        for (int i = 1; i <= k; i++) {
            ret = (ret + dp[n][i]) % mod;
        }
        System.out.println(ret);
        sc.close();
    }
}