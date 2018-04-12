import java.util.*;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || pushA.length == 0) {
            return false;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int index1 = 0, index2 = 0;
        while (index2 != popA.length) {
            if (stack.isEmpty() || stack.peek() != popA[index2]) {
                if (index1 == pushA.length) {
                    break;
                }
                stack.push(pushA[index1++]);
            } else {
                stack.pop();
                index2++;
            }
        }
        return index2 == popA.length;
    }
}
