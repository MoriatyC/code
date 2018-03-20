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
    }
    /*
    
    //使用map存储节点对应关系，第一次复制正常链表，第二次复制随机链表
        if (pHead == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode ret = dummy;
        RandomListNode origin = new RandomListNode(-1);
        origin.next = pHead;
        while (pHead != null) {
            dummy.next = new RandomListNode(pHead.label);
            dummy = dummy.next;
            map.put(pHead, dummy);
            pHead = pHead.next;
        }
        pHead = origin.next;
        dummy = ret.next;
        while (pHead != null) {
            if (pHead.random != null) {
                dummy.random =  map.get(pHead.random);
            }
            pHead = pHead.next;
            dummy = dummy.next;
        }
        return ret.next;
    
    
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head != null) {
            copyList(head);将原链表复制一份A A' S S' C C'
            generateRandom(head);遍历链表在X’将随机链表结点接上
            return split(head);将两个链表分开
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
    
    */
}