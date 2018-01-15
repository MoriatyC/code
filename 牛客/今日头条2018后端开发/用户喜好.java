import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int userCount = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= userCount; i++) {
            int tmp = sc.nextInt();
            List<Integer> list = map.getOrDefault(tmp, new ArrayList<Integer>());
            list.add(i);
            map.put(tmp, list);
        }
        int queryCount = sc.nextInt();
        for (int i = 0; i < queryCount; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();
            if (map.containsKey(k)) {
                List<Integer> list = map.get(k);
                int left = left(list, l, r);
                if (left == -1){
                    System.out.println(0);
                } else {
                    int right = right(list, l, r);
                    System.out.println(right - left + 1);
                }
            } else {
                System.out.println(0);
            }
         
        }
        sc.close();
    }
    static int left(List<Integer> list, int l, int r) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= l && list.get(i) <= r) {
                return i;
            }
        }
        return -1;
    }
    static int right(List<Integer> list, int l, int r) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) >= l && list.get(i) <= r) {
                return i;
            }
        }
        return -1;
    }
}