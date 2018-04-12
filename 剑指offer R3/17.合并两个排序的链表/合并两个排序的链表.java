/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode ret = new ListNode(0);
        ListNode dummy = ret;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                dummy.next = list1;
                list1 = list1.next;
                dummy = dummy.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
                dummy = dummy.next;
            }
        }
        if (list1 != null) {
            dummy.next = list1;
        }
        if (list2 != null) {
            dummy.next = list2;
        }
        return ret.next;
    }
}
/*
if (list1 == null) {
           return list2;
       }
       if (list2 == null) {
           return list1;
       }
        ListNode dummy = new ListNode(0);
        ListNode ret = dummy;
       while (list1 != null && list2 != null) {
           if (list1.val < list2.val) {
               dummy.next = list1;
               list1 = list1.next;
               dummy = dummy.next;
           } else {
               dummy.next = list2;
               list2 = list2.next;
               dummy = dummy.next;
           }
       }
        if (list1 != null) {
            dummy.next = list1;
        }
        if (list2 != null) {
            dummy.next = list2;
        }
        return ret.next;
        */