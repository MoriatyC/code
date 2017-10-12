package com.dlut.cmh.practice;

import java.util.Random;

public class Main {
    static void swap(int nums[], int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
    static void solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && !isEven(arr[left])) {
                left++;
            }
            while (left < right && isEven(arr[right])) {
                right--;
            }
            swap(arr, left, right);
        }
    }
    static boolean isEven(int i) {
        return (i & 1) == 0;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        solution(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
