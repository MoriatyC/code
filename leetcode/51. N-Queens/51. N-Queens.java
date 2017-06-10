public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        boolean[] col = new boolean[2 * n];
        boolean[] d1 = new boolean[2 * n];
        boolean[] d2 = new boolean[2 * n];
        helper(ret, col, d1, d2, n, 0, cur);
        return ret;
    }
    void helper(List<List<String>> ret, boolean[] col, boolean[] d1, boolean[] d2, int n, int curRow, List<String> list) {
        if (curRow == n) {
            ret.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] || d1[i - curRow + n - 1] || d2[i + curRow]) {
                continue;
            }
            col[i] = true;
            d1[i - curRow + n - 1] = true;
            d2[i + curRow] = true;
            char[] temp = new char[n];
            Arrays.fill(temp, '.');
            temp[i] = 'Q';
            list.add(new String(temp));
            
            helper(ret, col, d1, d2, n, curRow + 1, list);
            
            col[i] = false;
            d1[i - curRow + n - 1] = false;
            d2[i + curRow] = false;
            list.remove(list.size() - 1);
        }
    }


}