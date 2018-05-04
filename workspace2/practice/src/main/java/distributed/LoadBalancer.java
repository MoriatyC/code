package distributed;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author : Menghui Chen
 * @version ：2018年5月3日 下午7:36:51
 * @Description:
 */
public class LoadBalancer<T> {
    private static Integer pos = 0;
    private static MessageDigest md5 = null;
    private static int numberOfReplicas;
    private SortedMap<String, T> circle = new TreeMap<>();
    /**
     * @param numberOfReplicas, 虚拟结点个数
     * @param nodes， 实际结点集合
     */
    public LoadBalancer(int numberOfReplicas, Collection<T> nodes) {
        this.numberOfReplicas = numberOfReplicas;
        for (T node: nodes) {
            add(node);
        }
    }
    /**
     * @param node
     * 
     * 为每个加入的实际结点添加虚拟结点
     */
    public void add(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            //key：虚拟结点的string，用类似node1:1, node1:2, node1:3类似用这样的分隔方式设置虚拟节点
            //value：实际结点
            circle.put(hash(node.toString() + i), node);
        }
    }
    /**
     * @param node
     * 删除相应实际结点对应的虚拟结点
     */
    public void remove(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.remove(hash(node.toString() + i));
        }
    }
    
    /**
     * @param key
     * @return 返回该key结点将要存储的实际结点
     */
    public T getRealNode(Object key) {
        if (circle.isEmpty()) {
            return null;
        }
        String hash = hash(key.toString());
        if (!circle.containsKey(hash)) {
            SortedMap<String, T> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }
    public long getSize() {
        return circle.size();
    }
    public static String hash(String key) {
        if (md5 == null) {
            try {
                md5 = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalStateException("no md5 algrithm found");
            }
        }
        md5.reset();
        md5.update(key.getBytes());
        byte[] bKey = md5.digest();
        
        // 将md5摘要转成long格式
        long result = ((long) (bKey[3] & 0xFF) << 24)
                | ((long) (bKey[2] & 0xFF) << 16 
                | ((long) (bKey[1] & 0xFF) << 8) 
                | (long) (bKey[0] & 0xFF));
        return String.valueOf(result & 0xffffffffL);
    }



    public static String getServerByAddWeightRoundRobin() {
        Map<String, Integer> serverMap = new LinkedHashMap<>();
        serverMap.putAll(IpMap.serverWeightMap);
        Set<String> keySet = serverMap.keySet();
        Iterator<String> iterator = keySet.iterator();

        List<String> serverList = new ArrayList<String>();
        while (iterator.hasNext()) {
            String server = iterator.next();
            int weight = serverMap.get(server);
            for (int i = 0; i < weight; i++)
                serverList.add(server);
        }
        String server = null;
        synchronized (pos) {
            if (pos == keySet.size()) {
                pos = 0;
            }
            server = serverList.get(pos);
            pos++;
        }
        return server;
    }

    
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Set<String> nodes = new HashSet<>();
        nodes.add("A");
        nodes.add("B");
        nodes.add("C");
        nodes.add("D");
        nodes.add("E");
        LoadBalancer<String> lb = new LoadBalancer<>(100, nodes);
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < 10000000; i++) {
            String real = lb.getRealNode(i + "");
            count.put(real, count.getOrDefault(real, 0) + 1);
        }
        for (String i: count.keySet()) {
            System.out.println(count.get(i));
        }
    }

}
