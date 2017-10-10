package com.dlut.cmh.practice;

import java.math.BigDecimal;

public class Main {
    
    static void solution(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        while (increament(number)) {
            print(number);
        }
    }
    
    static boolean increament(char[] number) {
        boolean flag = true;
        int over = 1;
        for (int i = number.length - 1; i >= 0; i--) {
            int cur = number[i] - '0' + over;
            if (cur < 10) {
                number[i] = (char)(cur + '0');
                break;
            } else {
                cur -= 10;
                number[i] = (char)(cur + '0');
                if (i == 0) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    static void print(char[] number) {

        boolean isFirst = true;
        for (int i = 0; i < number.length; i++) {
            if (isFirst && number[i] != '0') {
                isFirst = false;
            }
            if (!isFirst) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        solution(2);
    }
}
