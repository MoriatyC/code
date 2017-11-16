/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        int len1 = 0;
        int len2 = 0;
        while (a != null) {
            len1++;
            a = a.next;
        }
        while (b != null) {
            len2++;
            b = b.next;
        }
        int dis;
        if (len1 > len2) {
            a = headA;
            b = headB;
            dis = len1 - len2;
        } else {
            a = headB;
            b = headA;
            dis = len2 - len1;
        }
        for (int i = 1; i <= dis; i++) {
            a = a.next;
        }
        while (a != null) {
            if (a.val == b.val) {
                break;
            }
            a = a.next;
            b = b.next;
        }
        return a;
    }
}