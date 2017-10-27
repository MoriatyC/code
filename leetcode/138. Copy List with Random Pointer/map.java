/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode node = simple(head);
        RandomListNode ret = new RandomListNode(0);
        ret.next = node;
        while (head != null) {
            RandomListNode cur = map.get(head);
            cur.random = map.get(head.random);
            head = head.next;
        }
        return ret.next;
    }
    public RandomListNode simple(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = new RandomListNode(head.label);
        map.put(head, cur);
        dummy.next = cur;
        head = head.next;
        
        while (head != null) {
            RandomListNode tmp = new RandomListNode(head.label);
            cur.next = tmp;
            cur = cur.next;
            map.put(head, cur);
            head = head.next;
        }
        return dummy.next;
    }
    
}