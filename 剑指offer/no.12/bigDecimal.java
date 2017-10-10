package com.dlut.cmh.practice;

import java.math.BigDecimal;

public class Main {
    static void solution(int n) {
        if (n <= 0) {
            return;
        }
        BigDecimal num = new BigDecimal("1");
        int count = 0;
        while (count++ < n) {
            num = num.multiply(new BigDecimal("10"));
        }
        BigDecimal addend = new BigDecimal("1");
        for (BigDecimal i = addend; i.compareTo(num) < 0; i = i.add(addend)) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        solution(2);
    }
}
