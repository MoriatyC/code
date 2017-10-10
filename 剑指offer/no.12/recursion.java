package com.dlut.cmh.practice;

import java.math.BigDecimal;

public class Main {
    
    static void solution(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i <= 9; i++) {
            number[0] = (char)(i + '0');
            recursion(number, 1);
        }
    }
    static void recursion(char[] number, int index) {
        if (index == number.length) {
            print(number);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            number[index] = (char)(i + '0');
            recursion(number, index + 1);
        }
    }
    static void print(char[] number) {
        if (Integer.valueOf(String.valueOf(number)) == 0) {
            return ;
        }
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
