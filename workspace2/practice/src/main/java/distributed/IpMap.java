package distributed;

import java.util.LinkedHashMap;

/**
 * @author : Menghui Chen
 * @version ：2018年5月3日 下午8:49:41
 * @Description:
 */
public class IpMap {
    /**
     * key: Ip
     * Value: 权重
     */
    public static LinkedHashMap<String, Integer> serverWeightMap = new LinkedHashMap<>();
    static {
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.101", 1);
        serverWeightMap.put("192.168.1.102", 4);
        serverWeightMap.put("192.168.1.103", 1);
        serverWeightMap.put("192.168.1.104", 1);
        serverWeightMap.put("192.168.1.105", 3);
        serverWeightMap.put("192.168.1.106", 1);
        serverWeightMap.put("192.168.1.107", 2);
        serverWeightMap.put("192.168.1.108", 1);
        serverWeightMap.put("192.168.1.109", 1);
    }
}
