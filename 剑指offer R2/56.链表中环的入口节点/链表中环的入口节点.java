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
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int count = 0;
        while (fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = dummy;
        slow = dummy;
        for (int i = 1; i <= count; i++) {
            fast = fast.next;
        }
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}


/*if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead.next;
        int count = 1;
        while (fast != null && fast.next != null) {
            if (fast.val == slow.val) {
                break;
            }
            count++;
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = pHead;
        fast = pHead;
        while (count-- > 0) {
            fast = fast.next;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

*/