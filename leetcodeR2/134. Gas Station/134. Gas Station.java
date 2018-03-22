class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0) {
            return -1;
        }
        int sum = 0;
        int left = 0;
        int ret = 0;
        for (int i = 0; i < gas.length; i++) {
            gas[i] -= cost[i];
            sum += gas[i];
            if (sum < 0) {
                left += sum;
                sum = 0;
                ret = i + 1;
            }
        }
        if (sum + left < 0) {
            return -1;
        }
        return ret;
    }
}