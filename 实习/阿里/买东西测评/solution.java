package first_maven;

import java.util.Map.Entry;
import java.util.*;
public class Main{
//    public static final String[] NAMES = {"bom1", "bom2", "bom3", "bom4", "bom5", "bom6", "bom7" ,"bom8", "bom9"};
    static List<Integer> best = new ArrayList<>();
    static List<Integer> ret = new ArrayList<>();
    public static String[] name;
    public static Map<String, Integer> resolve(List<Integer> orders, Map<String, List<Integer>> boms) {
        int n = orders.size();//n种商品
        int m = boms.size();//m种组合
        name = new String[boms.size()];
        Set<String> set = boms.keySet();
        int nameCnt = 0;
        for (String item: set) {
            name[nameCnt++] = item;
        }
        int[] max = new int[]{n, m};//第一个表示剩余种类，第二个表示使用的种类
        backtracking(orders, boms, 0, max);
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < best.size(); i++) {
            if (best.get(i) != 0) {
                result.put(name[i], best.get(i));
            }
        }
        return result;
    }
    public static void backtracking(List<Integer> orders, Map<String, List<Integer>> boms, int index, int[] max) {
        if (index == boms.size()) {
            bestJudge(orders, boms, max);
            return;
        }
        int limit = Integer.MAX_VALUE; 
        List<Integer> bom = boms.get(name[index]);//当前bom
        for (int i = 0; i < bom.size(); i++) {
            if (bom.get(i) == 0) {
                continue;
            }
            limit = Math.min(limit, orders.get(i) / bom.get(i));//当前物料清单可用最大次数
        }
        for (int i = 0; i <= limit; i++) {
            ret.add(i);
            List<Integer> mark = new ArrayList<>(orders);
            for (int j = 0; j < orders.size(); j++) {
                int remain = orders.get(j);
                remain -= i * bom.get(j);
                orders.set(j, remain);
            }
            backtracking(orders, boms, index + 1, max);
            orders = mark;
            ret.remove(ret.size() - 1);
        }
        
    }
    public static void bestJudge(List<Integer> orders, Map<String, List<Integer>> boms, int[] max) {
        //max[]第一个表示剩余种类，第二个表示使用的种类
        int count = 0;//剩余种类数
        int kind = 0;//使用组合数
        for (int i = 0; i < ret.size(); i++) {
            if (ret.get(i) != 0) {
                kind++;
            }
        }
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i) != 0) {
                count++;
            }
        }
        if (count < max[0] || (count == max[0] && kind < max[1])) {
            best = new ArrayList<>(ret);
            max[0] = count;
            max[1] = kind;
        } 
    }
    public static void main(String[] args) {
//        List<Integer> order = Arrays.asList(new Integer[]{2,3,1});
//        order = new ArrayList<>(order);
//        Map<String, List<Integer>> boms = new HashMap<>();
//        boms.put("bom1", Arrays.asList(new Integer[]{2,1,1}));
//        boms.put("bom2", Arrays.asList(new Integer[]{1,1,0}));
//        boms.put("bom3", Arrays.asList(new Integer[]{0,1,1}));
////        boms.put("bom4", Arrays.asList(new Integer[]{1,1,1}));
////        boms.put("bom5", Arrays.asList(new Integer[]{1,0,1}));
////        boms.put("bom6", Arrays.asList(new Integer[]{1,2,0}));
//        Map<String, Integer> ret = resolve(order, boms);
//        for (Entry<String,Integer> item: ret.entrySet()) {
//            System.out.println(item.getKey() + "  " + item.getValue());
//        }
//        System.out.println(ret);
        List<Integer> order = new ArrayList<Integer>();
        Map<String, List<Integer>> boms = new HashMap<String, List<Integer>>();

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        Integer n = Integer.parseInt(line.split(",")[0]);
        Integer m = Integer.parseInt(line.split(",")[1]);

        line = in.nextLine();
        String[] itemCnt = line.split(",");
        for(int i = 0; i < n ; i++){
            order.add(Integer.parseInt(itemCnt[i]));
        }

        for(int i = 0; i < m; i++){
            line = in.nextLine();
            String[] bomInput = line.split(",");
            List<Integer> bomDetail = new ArrayList<Integer>();

            for(int j = 1; j <= n; j++ ){
                bomDetail.add(Integer.parseInt(bomInput[j]));
            }
            boms.put(bomInput[0], bomDetail);
        }
        in.close();

        Map<String, Integer> res = resolve(order, boms);

        System.out.println("match result:");
        for(String key : res.keySet()){
            System.out.println(key+"*"+res.get(key));
        }
    }
}