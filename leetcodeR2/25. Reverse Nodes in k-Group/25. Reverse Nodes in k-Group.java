/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        List<ListNode> headList = new ArrayList<>();
        ListNode curHead = head;
        ListNode dummy = head;
        int count = 0;
        while (head != null) {
            count++;
            if (count == k) {
                ListNode tmp = head.next;
                reverse(curHead, tmp);
                headList.add(head);
                head = tmp;
                curHead = tmp;
                count = 0;
            } else {
                head = head.next;
            }
        }
        if (headList.size() == 0) {
            return dummy;
        }
        for (int i = 0; i < headList.size() - 1; i++) {
            ListNode tail = getTail(headList.get(i));
            tail.next = headList.get(i + 1);
        }
        getTail(headList.get(headList.size() - 1)).next = curHead;
        return headList.get(0);
    }
    public ListNode getTail(ListNode node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }
    public void reverse(ListNode cur, ListNode head) {
        ListNode last = null;
        ListNode tmp;
        while (cur != head) {
            tmp = cur.next;
            cur.next = last;
            last = cur;
            cur = tmp;
        } 
    }
}