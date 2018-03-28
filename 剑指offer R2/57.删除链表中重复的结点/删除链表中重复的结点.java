/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
import java.util.Map;
import java.util.HashMap;
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null) {
            return pHead;
        }
        ListNode pre = new ListNode(0);
        pre.next = pHead;
        ListNode ret = pre;
        while (pHead != null && pHead.next != null) {
            ListNode next = pHead.next;
            if (pHead.val == next.val) {
                while (next != null && next.val == pHead.val) {
                    next = next.next;
                }
                pre.next = next;
                pHead = next;
            } else {
                pre = pHead;
                pHead = pHead.next;
            }
        }
        return ret.next;
    }
}
/*

if (pHead == null) {
            return null;
        }
        ListNode fade = new ListNode(0);
        fade.next = pHead;
        ListNode pre = fade;
        ListNode cur = fade.next;
        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                pre = cur;
                cur = cur.next;
            } else {
                int tmp = cur.val;
                while (cur != null && tmp == cur.val) {
                        cur = cur.next;
                }
                pre.next = cur;
            }
        }
        return fade.next;
*/