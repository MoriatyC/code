import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        List<Integer> list = new ArrayList<>();
        char[] arr = str.toCharArray();
        if (arr.length > 1) {
            int count = 1;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == arr[i - 1]) {
                    count++;
                } else {
                    list.add(count);
                    count = 1;
                }
            }
            list.add(count);
            int size = list.size();
            int sum = 0;
            for (int item: list) {
                sum += item;
            }
            System.out.format("%.2f", sum * 1.0 / size);
        } else {
            System.out.println("1.00");
        }
        sc.close();
    }
}