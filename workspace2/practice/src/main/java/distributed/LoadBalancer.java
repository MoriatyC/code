package distributed;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author : Menghui Chen
 * @version ：2018年5月3日 下午7:36:51
 * @Description:
 */
public class LoadBalancer<T> {
    private static Integer pos = 0;
    private static MessageDigest md5 = null;
    private static int numberOfReplicas;
    private Map<Long, T> circle = new TreeMap<>();

    public static long hash(String key) {
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
        return result & 0xffffffffL;
    }

    public static String getServerByConsistentHash() {

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

    public static void testDigest() {
        try {
            String myinfo = "1";
            MessageDigest alga = MessageDigest.getInstance("MD5");
            // java.security.MessageDigest
            // alga=java.security.MessageDigest.getInstance("SHA-1");
            alga.update(myinfo.getBytes());
            byte[] digesta = alga.digest();
            System.out.println("本信息摘要是:" + byte2hex(digesta));
            // 通过某中方式传给其他人你的信息(myinfo)和摘要(digesta) 对方可以判断是否更改或传输正常
            MessageDigest algb = MessageDigest.getInstance("MD5");
            algb.update(myinfo.getBytes());
            if (algb.isEqual(digesta, algb.digest())) {
                System.out.println("信息检查正常");
            } else {
                System.out.println("摘要不相同");
            }
        } catch (java.security.NoSuchAlgorithmException ex) {
            System.out.println("非法摘要算法");
        }
    }

    public static String byte2hex(byte[] b) // 二行制转字符串
    {
//        for (byte a:b) {
//            System.out.println(a);
//        }
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
            if (n < b.length - 1)
                hs = hs + ":";
        }
        return hs.toUpperCase();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // for (int i = 0; i < 25; i++) {
        // System.out.println(getServerByAddWeightRoundRobin());
        // }
        testDigest();
        System.out.println(hash("1"));
    }

}
