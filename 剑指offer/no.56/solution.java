/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        int count = 1;
        ListNode fade = new ListNode(0);
        fade.next = pHead;
        ListNode slow = fade.next;
        ListNode fast = fade.next.next;
        while (fast != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
        if (fast == null) {
            return null;
        }
        fast = fade;
        while (count-- > 0) {
            fast = fast.next;
        }
        slow = fade;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}