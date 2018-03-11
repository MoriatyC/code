class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        LinkedList<Character> stack = new LinkedList<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(')');
            } else if (arr[i] == '[') {
                stack.push(']');
            } else if (arr[i] == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || arr[i] != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}