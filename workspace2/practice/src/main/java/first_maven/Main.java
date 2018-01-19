package com.dlut.cmh.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
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
        if (arr == null || arr.length == 0 || k <= 0) {
            return;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        pq.offer(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (pq.size() < k) {
                pq.offer(arr[i]);
            } else {
                int top = pq.peek();
                if (top > arr[i]) {
                    pq.poll();
                    pq.offer(arr[i]);
                }
            }
        }
        for (int i : pq) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return Integer.valueOf(s2) - Integer.valueOf(s1);
            }
        });
    }
}