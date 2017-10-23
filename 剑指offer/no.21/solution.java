class MinStack {

    /** initialize your data structure here. */
    LinkedList<Integer> stack;
    LinkedList<Integer> min_stack;
    public MinStack() {
        stack = new LinkedList<>();
        min_stack = new LinkedList<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (min_stack.isEmpty() || x < min_stack.peek()) {
            min_stack.push(x);
        } else {
            min_stack.push(min_stack.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        min_stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
    
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */