package first_maven;

import java.math.BigInteger;

public class Main{
    public static int hammingWeight(int n) {
        int ones = 0;
        while(n!=0) {
            ones = ones + (n & 1);
            n = n>>>1;
        }
        return ones;
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if ((i & 1) == 1) {
                System.out.println(i);
            } else {
                System.out.println("no");
            }
            
        }
    }
}
