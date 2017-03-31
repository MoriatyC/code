/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode ret = head;
        if(head == null) return head;
        ListNode right = ret.next;  
        ListNode temp;
        while(right != null)
        {
            temp = ret;
            ret = right;
            right = ret.next;
            ret.next = temp;
        }
        head.next = null;
        return ret;
    }
}