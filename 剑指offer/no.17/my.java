/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode start = new ListNode(0);
        ListNode ret = start;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                start.next = l1;
                start = start.next;
                l1 = l1.next;
            } else {
                start.next = l2;
                start = start.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            start.next = l1;
        }
        if (l2 != null) {
            start.next = l2;
        }
        return ret.next;
    }
}