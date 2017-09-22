class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        while (p != null && p.next != null) {
            ListNode node = p.next;
            p.next = node.next;
            
            ListNode ptr = dummy;
            while (ptr != p && ptr.next.val < node.val) {
                ptr = ptr.next;
            }
            ListNode temp = ptr.next;
            ptr.next = node;
            node.next = temp;
            if (p.next == node) {
                p = p.next;
            }
        }
        return dummy.next;
    }
}