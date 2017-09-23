/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        reverse(reverse(head, sb1), sb2);
        return sb1.toString().equals(sb2.toString());
    }
    ListNode reverse(ListNode head, StringBuilder sb) {
        ListNode tmp;
        ListNode pre = null;
        while (head != null) {
            sb.append(head.val);
            tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}