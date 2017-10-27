/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head != null) {
            copyList(head);
            generateRandom(head);
            return split(head);
        }
        return null;
        
    }
    public RandomListNode split(RandomListNode head) {
        RandomListNode copy = head.next;
        RandomListNode ret = head.next;
        head.next = copy.next;
        head = head.next;
        while (head != null) {
            copy.next = head.next;
            copy = copy.next;
            head.next = copy.next;
            head = head.next;
        }
        return ret;
    }
    public void generateRandom(RandomListNode head) {
        RandomListNode copy;
        RandomListNode tmp;
        while (head != null) {
            copy = head.next;
            if (head.random != null) {
                copy.random = head.random.next;
            }
            head = copy.next;
        }
    }
    public void copyList(RandomListNode head) {
        RandomListNode tmp;
        while (head != null) {
            RandomListNode copy = new RandomListNode(head.label);
            tmp = head.next;
            head.next = copy;
            copy.next = tmp;
            head = tmp;
        }
    }
}