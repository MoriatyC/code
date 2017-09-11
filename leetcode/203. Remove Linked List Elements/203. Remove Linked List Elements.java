/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode first = new ListNode(0);
        while (head != null && head.val == val) {
            head = head.next;
        }
        first.next = head;
        while (head != null) {
            while (head.next != null && head.next.val == val) {
                head.next = head.next.next;
            } 
            head = head.next;
        }
        return first.next;
    }
}