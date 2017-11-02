package com.dlut.cmh.practice;

import java.util.Random;

public class Main {
    public static int partion(int[] arr, int left, int right) {
        if (left >= right) {
            return left;
        }
        Random random = new Random();
        int pivot = random.nextInt(right - left + 1) + left;
        swap(arr, pivot, right);
        int small = left - 1;
        for (int i = left; i < right; i++) {
            if (arr[i] < arr[right]) {
                small++;
                if (i != small) {
                    swap(arr, i, small);
                }
            }
        }
        swap(arr, ++small, right);
        return small;
    }
    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    public static void solution(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            return;
        }
        k = k - 1;
        int pivot = 0;
        int left = 0;
        int right = arr.length - 1;
        pivot = partion(arr, left, right);
        while (pivot != k) {
            if (pivot > k) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
            pivot = partion(arr, left, right);
        } 
        
    }
    public static void main(String[] args) {
        int[] arr = {12,56,645,453,34,535,234,523,535,45,37,4567,58,7,5678,678,432,121,12,3129,8,7,6,5,4,3,2,1};
        solution(arr, 4);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}