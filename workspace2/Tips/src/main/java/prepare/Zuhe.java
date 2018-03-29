package prepare;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
* @author : Menghui Chen 
* @version ：2018年3月19日 上午10:22:36 
* @Description:
*/
public class Zuhe {
    public static void dfs(int[] arr, List<Integer> list, int m, int index) {
        if (list.size() == m || index == arr.length) {
            for (int i: list) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        dfs(arr, list, m, index + 1);
        list.add(arr[index]);
        dfs(arr, list, m, index + 1);
        list.remove(list.size() - 1);
    }
    public static void main(String[] args) {
        String s = "aab";
        int[] arr = {1, 2, 3};
        dfs(arr, new ArrayList<Integer>(), 3, 0);
    }
}
