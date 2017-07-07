/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, (i, j) -> i.val - j.val);

        ListNode head = new ListNode(0);
        ListNode ret = head;
        for (ListNode list: lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        while (queue.size() != 0) {
            head.next = queue.poll();
            head = head.next;//现在的head就是刚刚poll出来的节点
            if (head.next != null) {
                queue.add(head.next);
            }
        }
        return ret.next;
    }
}