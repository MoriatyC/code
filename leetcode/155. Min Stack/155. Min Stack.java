class MinStack {

    /** initialize your data structure here. */
    LinkedList<Integer> stack;
    LinkedList<Integer> min_stack;
    public MinStack() {
        stack = new LinkedList<>();
        min_stack = new LinkedList<>();
    }
    
    public void push(int x) {
        stack.offer(x);
        if (min_stack.isEmpty() || x < this.getMin()) {
            min_stack.offer(x);
        } else {
            min_stack.offer(this.getMin());
        }
    }
    
    public void pop() {
        stack.pollLast();
        min_stack.pollLast();
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() {
        return min_stack.peekLast();
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