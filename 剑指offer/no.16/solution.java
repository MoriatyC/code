/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode tmp ;
        while (head.next != null) {
            tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        } 
        head.next = pre;
        return head;
    }
}