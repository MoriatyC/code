public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if (n == 0) {
            ret.add("");
            return ret;
        }
        StringBuilder sb = new StringBuilder();
        helper(n, n, ret, sb);
        return ret;
    }
    void helper(int left, int right, List<String> ret, StringBuilder sb1) {
        StringBuilder sb = new StringBuilder(sb1);
        if (left > right) {
            return;
        }
        if (right == 0) {
            ret.add(sb.toString());
            return;
        }
        if (left > 0) {
            sb.append("(");
            helper(left - 1, right, ret, sb);
            sb.setLength(sb.length() - 1);
        }
        if (right > 0) {
            sb.append(")");
            helper(left, right - 1, ret, sb);
        }
    }
}