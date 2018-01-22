package first_maven;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void exactFloat(String number) {
        Pattern p = Pattern.compile("(\\d)+.(\\d+)(\\((\\d+)\\))*");
        Matcher m = p.matcher(number);
        if (m.find()) {
            String finite = m.group(2);
            int integer = Integer.valueOf(m.group(1));
            if (m.group(4) == null) {
                int son = (int)(integer * Math.pow(10, finite.length()) + Integer.valueOf(finite));
                int mom = (int)(Math.pow(10, finite.length()));
                System.out.println(son / hyperGcd(mom, son) + "/" + mom / hyperGcd(mom, son));
            } else {
                String loop = m.group(4);
                int n = finite.length();
                int mm = loop.length();
                int son =  (int)((integer * Math.pow(10, n) + Integer.valueOf(finite)) * (Math.pow(10, mm) - 1)) 
                        + Integer.valueOf(loop);
                int mom = (int)(Math.pow(10, n) * (Math.pow(10, mm) - 1));
                System.out.println(son / hyperGcd(mom, son) + "/" + mom / hyperGcd(mom, son));
            }
        } else {
            System.out.println("请检查输入是否正确");         
        }
    }
    public static int GCD(int x, int y) {
        return (y == 0) ? x : GCD(y, x % y); 
    }
    public static int hyperGcd(int x, int y) {
        if (x < y) {
            return hyperGcd(y, x);
        }
        if (y == 0) {
            return x;
        } else {
            if (isEven(x)) {
                if (isEven(y)) {
                    return hyperGcd(x >> 1, y >> 1) << 1;
                } else {
                    return hyperGcd(x >> 1, y);
                }
            } else {
                if (isEven(y)) {
                    return hyperGcd(x, y >> 1);
                } else {
                    return hyperGcd(x - y, y);
                }
            }
        }
        
    }
    public static boolean isEven(int x) {
        return x % 2 == 0;
    }
    public static void main(String[] args) {
        exactFloat("0.3(3)");
    }
}