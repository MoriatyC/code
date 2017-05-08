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
        int countA = 0;
        int countB = 0;
        int diff = 0;
        ListNode temp = headA;
        ListNode big;
        ListNode small;
        ListNode ret = null;
        while (temp != null) {
            countA++;
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            countB++;
            temp = temp.next;
        }
        if (countA > countB) {
            big = headA;
            small = headB;
            diff = countA - countB;
        } else {
            big = headB;
            small = headA;
            diff = countB - countA;
        }
        while (diff-- > 0) {
            big = big.next;
        }
        while (small != null) {
            if (small.val == big.val) {
                ret = small;
                break;
            }
            small = small.next;
            big = big.next;
        }
        return ret;
    }
}