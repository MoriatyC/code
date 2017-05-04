package first_maven;

import java.util.Scanner;
public class Main {
    static class Pair {

        int pass;
        int score;
        Pair(int first, int second) {
            this.pass = first;
            this.score = second;
        }
        Pair add(int[] a, int s) {
            if (score <= s) { // 可以过关
                return new Pair(pass + 1, pass + 2 < a.length ? a[pass + 2] : 0);
            } else {
                return new Pair(pass, score - s);
            }
        }
        static Pair max(Pair p1, Pair p2) {
            if (p1.pass > p2.pass) {
                return p1;
            } else if (p1.pass < p2.pass) {
                return p2;
            } else if (p1.score < p2.score) {
                return p1;
            } else {
                return p2;
            }
        }
    }

    private static String solve(int[] a, int n, int m, int s, int t) {
        Pair[][] g = new Pair[m + 1][m + 1];// 答对i题，答错j题，最多能到x关，到达下一关所需分数为y
        g[0][0] = new Pair(0, 0);
        for (int i = 1; i <= m; i++) {
            g[0][i] = calc(a, i, t);
        }
        for (int i = 1; i <= m; i++) {
            g[i][0] = calc(a, i, s);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m - i; j++) {
                g[i][j] = Pair.max(g[i - 1][j].add(a, s), g[i][j - 1].add(a, t));
            }
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m - i; j++) {
                if (g[i][j].pass >= n) {
                    return String.valueOf(i);
                }
            }
        }
        return "No";
    }

    private static Pair calc(int[] a, int n, int s) {
        int pass = 0;
        int score = a[1];
        for (int j = 1; n >= 0 && j < a.length; j++) {
            if (n * s >= a[j]) { // 还能过这关
                n -= a[j] / s + (a[j] % s > 0 ? 1 : 0);// 消耗
                pass++;
                score = j + 1 < a.length ? a[j + 1] : 0;
            } else {
                score = a[j] - n * s;
                return new Pair(pass, score);
            }
        }
        return new Pair(pass, score);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            int t = sc.nextInt();
            int[] a = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                a[j] = sc.nextInt();
            }
            System.out.println(solve(a, n, m, s, t));
        }
    }
}
