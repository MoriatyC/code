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
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
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
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode ret = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                dummy.next = head1;
                head1 = head1.next;
                dummy = dummy.next;
            } else {
                dummy.next = head2;
                head2 = head2.next;
                dummy = dummy.next;
            }
        }
        if (head1 != null) {
            dummy.next = head1;
        }
        if (head2 != null) {
            dummy.next = head2;
        }
        return ret.next;
    }
    
}