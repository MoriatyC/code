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
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                cur = getDiff(cur);
            } else {
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
        }
        pre.next = cur;
        return dummy.next;
    }
    public ListNode getDiff(ListNode node) {
        while (node.next != null && node.val == node.next.val) {
            node = node.next;
        }
        return node.next;
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