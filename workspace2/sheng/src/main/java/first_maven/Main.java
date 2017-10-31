package first_maven;

import java.util.ArrayList;
import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }



 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Main {  

    public static void main(String[] args) {
       ListNode l1 = new ListNode(1);
       ListNode l2 = new ListNode(2);
       ListNode l3= new ListNode(3);
       l1.next = l2;
       l2.next = l3;
    }
}