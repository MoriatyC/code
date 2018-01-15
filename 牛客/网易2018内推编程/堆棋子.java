/*
链接：https://www.nowcoder.com/questionTerminal/27f3672f17f94a289f3de86b69f8a25b
来源：牛客网

小易将n个棋子摆放在一张无限大的棋盘上。
第i个棋子放在第x[i]行y[i]列。同一个格子允许放置多个棋子。
每一次操作小易可以把一个棋子拿起并将其移动到原格子的上、下、左、右的任意一个格子中。
小易想知道要让棋盘上出现有一个格子中至少有i(1 ≤ i ≤ n)个棋子所需要的最少操作次数.
*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] x = new int[size];
        int[] y = new int[size];
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            x[i] = sc.nextInt();
        }
        for (int i = 0; i < size; i++) {
            y[i] = sc.nextInt();
            ret[i] = Integer.MAX_VALUE;
        }
        minDis(x, y, size, ret);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(ret[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
    public static void minDis(int[] x, int[] y, int size, int[] ret) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] tmp = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    pq.add(Math.abs(x[k] - x[i]) + Math.abs(y[k] - y[j]));
                }
                int sum = 0;
                int index = 0;
                while(!pq.isEmpty()) {
                    sum += pq.poll();
                    ret[index] = Math.min(sum, ret[index++]);
                }
            }
        }
    }
}