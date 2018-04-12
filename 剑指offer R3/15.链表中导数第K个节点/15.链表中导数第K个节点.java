
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode fast = head;
        if (k <= 0) {
            return null;
        }
        while (k-- > 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            head = head.next;
        }
        return head;
    }
}
/*
        if (head == null || k < 0) {
            return null;
        }
        ListNode fast = head;
        for (int i = 1; i <= k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            head = head.next;
            fast = fast.next;
        }
        return head; */