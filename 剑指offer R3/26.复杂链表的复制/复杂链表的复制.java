/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
import java.util.*;
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode tmp = dummy;
        RandomListNode origin = pHead;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (pHead != null) {
            RandomListNode cur = new RandomListNode(pHead.label);
            dummy.next = cur;
            dummy = dummy.next;
            map.put(pHead, dummy);
            pHead = pHead.next;
        }
        dummy = tmp.next;
        while (origin != null) {
            dummy.random = map.get(origin.random);
            origin = origin.next;
            dummy = dummy.next;
        }
        return tmp.next;
    }
    /*
    
     if (pHead == null) {
            return pHead;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode origin = pHead;
        RandomListNode head = dummy;
        while (pHead != null) {
            head.next = new RandomListNode(pHead.label);
            head = head.next;
            map.put(pHead, head);
            pHead = pHead.next;
        }
        head = dummy.next;
        while (origin != null) {
            head.random = map.get(origin.random);
            origin = origin.next;
            head = head.next;
        }
        return dummy.next;
    
    */
}