public class MinStack {
    LinkedList<Integer> stack;
    LinkedList<Integer> min;
    public MinStack() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        stack.push(number);
        if (min.isEmpty()) {
            min.push(number);
        } else {
            if (number < min.peekFirst()) {
                min.push(number);
            } else {
                min.push(min.peekFirst());
            }
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        min.pop();
        return stack.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        return min.peekFirst();
    }
}