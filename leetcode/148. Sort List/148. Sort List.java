/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        pre.next = null;
        
        head = sortList(head);
        slow = sortList(slow);
        
        
        
        return merge(head, slow);
    }
    public ListNode merge(ListNode p1, ListNode p2) {
        ListNode head = new ListNode(0);
        ListNode ret = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                head.next = p1;
                head = head.next;
                p1 = p1.next;
            } else {
                head.next = p2;
                head = head.next;
                p2 = p2.next;
            }
        }
        if (p1 != null) {
            head.next = p1;
        } else {
            head.next = p2;
        }
        return ret.next;
    }
}