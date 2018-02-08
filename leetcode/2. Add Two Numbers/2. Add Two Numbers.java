/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        ListNode cur = new ListNode(0);
        ListNode head = cur;
        head.next = cur;
        int in = 0;
        while (l1 != null || l2 != null) {
            in /= 10;
            if (l1 != null) {
                in += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                in += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(in % 10);
            cur = cur.next;
        }
        if (in >= 10) {
            cur.next = new ListNode(1);
        }
        return head.next;
    }
}