package com.dlut.cmh.demo;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int f = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();
        int ret = 0;
        while (f-- > 0 && d >= x) {
            ret++;
            d -= x;
            if (f == 0) {
                d -= p;
                f = 1;
            }
        }
        System.out.println(ret);
    }
}
