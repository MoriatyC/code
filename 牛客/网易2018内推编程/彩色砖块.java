import java.util.Scanner;
import java.util.HashSet;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
            }
        }
        if (set.size() > 2) {
            System.out.println(0);
            return;
        }
        if (set.size() == 2) {
            System.out.println(2);
            return;
        }
        System.out.println(1);
         
    }
}