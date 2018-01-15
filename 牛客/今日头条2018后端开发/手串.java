import java.awt.Color;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ret = 0;
        int n = sc.nextInt();//环上柱子的总数
        int m = sc.nextInt();//连续的间隔大小
        int c = sc.nextInt();//颜色总数
        ArrayList<ArrayList<Integer>> color = new ArrayList<>(c + 1);
        for (int i = 0; i < c + 1; i++) {
            color.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            int count = sc.nextInt();//当前柱子颜色总数
            for (int j = 0; j < count; j++) {
                int tmp = sc.nextInt();//当前柱子颜色
                color.get(tmp).add(i);
            }
        }
        for (int i = 1; i < c + 1; i++) {
            for (int j = 1; j < color.get(i).size(); j++) {
                if (color.get(i).get(j) - color.get(i).get(j - 1) + 1 <= m) {
                    ret++;
                    break;
                }
            }
            if (color.get(i).size() > 1) {
                if(Math.abs(color.get(i).get(0) - color.get(i).get(color.get(i).size() - 1)) + 1 <= m) {
                    ret++;
                }
            }
        }
        System.out.println(ret);
        sc.close();
    }
}