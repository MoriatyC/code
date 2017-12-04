class Solution {
    boolean helper(int num) {
        int cur = num;
        while (cur > 0) {
            int tmp = cur % 10;
            if (tmp == 0 || num % tmp != 0) {
                return false;
            }
            cur /= 10;
        }
        return true;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ret = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (helper(i)) {
                ret.add(i);
            }
        }
        return ret;
    }
}