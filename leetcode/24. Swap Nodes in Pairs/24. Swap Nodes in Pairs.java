/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = new ListNode(0);
        ListNode pre = first;
        pre.next = head;
        ListNode tmp;
        while (head != null && head.next != null) {
            tmp = head.next;
            head.next = head.next.next;
            tmp.next = head;
            pre.next = tmp;
            pre = tmp.next;
            head = head.next;
        }
        return first.next;
    }
}