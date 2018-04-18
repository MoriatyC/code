
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode ret = null;
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode tmp1 = pHead1;
        ListNode tmp2 = pHead2;
        while (tmp1.next != null) {
            tmp1 = tmp1.next;
        }
        
        while (tmp2.next != null) {
            tmp2 = tmp2.next;
        }
        if (tmp1 != tmp2) {
            return ret;
        }
        tmp2 = pHead2;
        tmp1 = pHead1;
        while (tmp1 != tmp2) {
            tmp1 = tmp1.next == null ? pHead2 : tmp1.next;
            tmp2 = tmp2.next == null ? pHead1 : tmp2.next;
        }
        return tmp1;
    }
}