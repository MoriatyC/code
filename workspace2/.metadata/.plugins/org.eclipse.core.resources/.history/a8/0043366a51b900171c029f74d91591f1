package com.dlut.cmh.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public  static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0) {
              return false;
          }
          LinkedList<Integer> stack = new LinkedList<>();
          int i1 = 0;
          int i2 = 0;
          stack.push(pushA[i1++]);
          while (i2 != popA.length) {
              int cur = popA[i2++];
              while (i1 != pushA.length && stack.peek() != cur) {
                  stack.push(pushA[i1++]);
              }
              if (stack.peek() == cur) {
                  stack.pop();
              } else {
                  return false;
              }
          }
          return true;
      }
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        l1.add(1);

        

        l2.add(1);
        System.out.println(solution(l1, l2));
    }
}
