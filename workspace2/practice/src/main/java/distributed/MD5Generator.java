package distributed;

import java.security.MessageDigest;

/** 
* @author : Menghui Chen 
* @version ：2018年5月4日 上午9:08:00 
* @Description:
*/
public class MD5Generator {
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
    public static void main(String[] args) {
        testDigest();
    }
}
