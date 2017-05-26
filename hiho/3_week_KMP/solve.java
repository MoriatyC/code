import java.util.Scanner;
public class Main {
    static int[] getNext(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        int[] next = new int[len + 1];
        next[0] = -1;
        next[1] = 0;
        for (int i = 1; i < len; i++) {
            int j = next[i];//前缀和后缀相等数
            while (j != -1 && chars[j] != chars[i]) {
                j = next[j];
            }
            next[i + 1] = j + 1;
        }
        return next;
    }
    static int solve(String pat, String ori) {
        int len1 = ori.length();
        int len2 = pat.length();
        int ans = 0;
        int j = 0;
        int[] next = getNext(pat);
        for (int i = 0; i < len1; i++) {
            while (j != -1 && pat.charAt(j) != ori.charAt(i)) {
                j = next[j];
            }
            j++;
            if (j == len2) {
                ans++;
                j = next[j];//相当于在末尾加了个空串继续进行匹配
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            String pat = sc.next();
            String ori = sc.next();
            int ans = solve(pat, ori);
            System.out.println(ans);
        }
    }
}