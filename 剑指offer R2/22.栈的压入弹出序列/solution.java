import java.util.*;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || pushA.length == 0 || popA == null || popA.length == 0 || popA.length != pushA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            while (pushIndex < pushA.length && (stack.empty() || stack.peek() != popA[i])) {
                stack.push(pushA[pushIndex++]);
            }
            if (stack.peek() == popA[i]) {
                stack.pop();
            } else {
                return false;
            }
        }
        return true;
    }
}