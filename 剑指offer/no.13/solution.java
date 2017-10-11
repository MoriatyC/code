package first_maven;

import java.util.LinkedList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ListMain {
    static ListNode solution(ListNode head, ListNode node) {
        if (head == null && node == null) {
            return head;
        }
        if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        } else if (node.next == null) {
            if (head.val == node.val) {
                return null;
            } else {
                ListNode tmp = head;
                while (tmp.next != node) {
                    tmp = tmp.next;
                }
                tmp.next = null;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3= new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        
        ListNode tmp = solution(l1, l1);
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }
}
