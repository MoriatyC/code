import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len  = sc.nextInt();
        int[] arr = new int[len];
        int crazy = 0;
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        LinkedList<Integer> list = new LinkedList<>();
        int min = 0;
        int max = len - 1;
        if (len == 1) {
            System.out.println(0);
            return;
        }
        if (len == 2) {
            System.out.println(arr[1] - arr[0]);
            return;
        }
        int flag = 1;
        while (max >= min) {
            if (flag == 1) {
                list.offerFirst(arr[min++]);
                list.offer(arr[max--]);
                flag *= -1;
            } else {
                list.offer(arr[min++]);
                list.offerFirst(arr[max--]);
                flag *= -1;
            }
        }
        int ret = 0;
        if (max == min) {
            ret = Math.max(Math.abs(arr[max] - list.peek()), Math.abs(arr[max] - list.peekLast()));
        }
        for (int i = 1; i < list.size(); i++) {
            ret += Math.abs(list.get(i) - list.get(i - 1));
        }
        System.out.println(ret);
    }
}