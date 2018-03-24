package com.dlut.cmh.Tips;

import java.util.Arrays;

public class Main {
    public static void solution(int n) {
        if (n == 0) {
            return;
        }
        int[] arr0 = new int[6 * n + 1];
        int[] arr1 = new int[6 * n + 1];
        int flag = -1;
        for (int i = 1; i <= 6; i++) {
            arr0[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            if (flag == -1) {
                for (int j = i; j <= i * 6; j++) {
                    for (int k = 1; k <= 6; k++) {
                        if (j - k <= 0){
                            continue;
                        }
                        arr1[j] += arr0[j - k];
                    }
                }
                flag *= -1;
                Arrays.fill(arr0, 0);
            } else {
                for (int j = i; j <= i * 6; j++) {
                    for (int k = 1; k <= 6; k++) {
                        if (j - k <= 0){
                            continue;
                        }
                        arr0[j] += arr1[j - k];
                    }
                }
                flag *= -1;
                Arrays.fill(arr1, 0);
            }
        }
        if (n % 2 == 1) {
            for (int i = n; i < arr0.length; i++) {
                double x= arr0[i] / Math.pow(6, n);
                System.out.println(x);
            }
        } else {
            for (int i = n; i < arr1.length; i++) {
                double x= arr1[i] / Math.pow(6, n);
                System.out.println(x);
            }
        }
    }
    public static void main(String[] args) {
        solution(3);
    }
}
