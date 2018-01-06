package first_maven;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ListMain {
    static void print(ListNode head) {
        if (head == null) {
            System.out.println("null");
        }
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    static ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode last = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        return last;
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> set1 = new HashSet<>();
        Set<ListNode> set2 = new HashSet<>();
        while (pHead1 != null && pHead2 != null) {
            if (set1.contains(pHead2)) {
                return pHead2;
            }
            if (set2.contains(pHead1)) {
                return pHead1;
            }
            set1.add(pHead1);
            set2.add(pHead2);
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        while (pHead1 != null) {
            if (set2.contains(pHead1)) {
                return pHead1;
            }
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (set1.contains(pHead2)) {
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3= new ListNode(3);
//        ListNode l4= new ListNode(4);
//        ListNode l5= new ListNode(5);
//        ListNode l6= new ListNode(6);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
        ListNode tmp = solution(l1);
        print(tmp);
     
    }
}
