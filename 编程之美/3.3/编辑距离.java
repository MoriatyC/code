import java.util.*;
public class Main {
         public static String calculateStringDistance(String a, String b) {
         int len1 = a.length();
         int len2 = b.length();
         int[][] dp = new int[len1 + 1][len2 + 2];//dp[i][j]字符串a的长度是i字符串b的长度是b，他们的相似度
         for (int i = 1; i <= len1; i++) {
             dp[i][0] = i;
         }
         for (int i = 1; i <= len2; i++) {
             dp[0][i] = i;
         }
         for (int i = 1; i <= len1; i++) {
             for (int j = 1; j <= len2; j++) {
                 if (a.charAt(i- 1) == b.charAt(j - 1)) {
                     dp[i][j] = dp[i - 1][j - 1];
                 } else {
                       dp[i][j] = dp[i - 1][j - 1] + 1;
                       dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                       dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                 }
             }
         }
         int ret = dp[len1][len2] + 1;
         return "1/" + ret;
     }
}