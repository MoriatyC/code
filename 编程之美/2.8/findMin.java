package first_maven;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void findMin(int n) {
        /**
         * 只需要将10k%N的结果与余数信息数组里非空的元素相加，再去模N，看看会不会出现新的余数
         * **/
        int sum = 0;
        List<List<Integer>> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer>());
        }
        list.get(1).add(0);
        for (int i = 1, j = 10 % n;;i++, j = (int)Math.pow(10, i) % n) {
            boolean ischanged = false;
            if (list.get(j).size() == 0) {
                list.get(j).add(i);
                ischanged = true;
            }
            for (int k = 0; k < n; k++) {
                if (list.get(k).size() != 0 && i > list.get(k).get(list.get(k).size() - 1) 
                        && list.get((k + j) % n).size() == 0) {
                    list.add((k + j) % n, new ArrayList<Integer>(list.get(k)));
                    list.get((k + j) % n).add(i);
                    ischanged = true;
                }
            }
            if (!ischanged) {
                break;
            }
            if (list.get(0).size() != 0) {
                for (int k = 0; k < list.get(0).size(); k++) {
                    sum += (int)Math.pow(10, list.get(0).get(k));
                }
                System.out.println(sum / n);
                break;
            }
        }
    }
 
    public static void main(String[] args) {
        findMin(12);
    }
}