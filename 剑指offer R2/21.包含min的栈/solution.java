import java.util.Stack;

public class Solution {
    public Stack<Integer> stack = new Stack<>();
    public Stack<Integer> min = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if (min.empty()) {
            min.push(node);
        } else {
            int top = min.peek();
            if (top < node) {
                min.push(top);
            } else {
                min.push(node);
            }
        }
        
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        if (stack.empty()) {
            return -1;
        }
        return stack.peek();
    }
    
    public int min() {
        if (stack.empty()) {
            return -1;
        }
        return min.peek();
    }
}