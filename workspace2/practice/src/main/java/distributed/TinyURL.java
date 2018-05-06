package distributed;

import java.util.Stack;

/** 
* @author : Menghui Chen 
* @version ：2018年5月6日 下午2:58:28 
* @Description:
*/
public class TinyURL {
    private final String origin = "www.baidu.com";
    private static int counter = 0;
    String code = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String DecimalToN(int num, int n) {
        if (num < 0) {
            return null;
        }
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (num >= n) {
                sb.append(num % n).append(" ");
                num /= n;
            } else {
                sb.append(num);
                break;
            }
        }
        String[] words = sb.toString().split(" ");
        StringBuilder ret = new StringBuilder();
        for(String item: words) {
            ret.append(code.charAt(Integer.valueOf(item)));
        }
        return ret.reverse().toString();
    }
    
    public String TinyURLGenarator(String longURL) {
        StringBuilder sb = new StringBuilder(origin);
        String suffix = DecimalToN(counter++, 62);
        String ret = sb.append("/").append(suffix).toString();
        //存到一个有过期时间的缓存中
        System.out.println(ret);
        return ret;
    }
    public static void main(String[] args) {
        
        TinyURL t = new TinyURL();
        t.TinyURLGenarator("asdf");
    }
}
