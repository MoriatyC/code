class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int index = 0;//当前最大丑数下标
        int[] ugly = new int[n];
        int m2 = 0;
        int m3 = 0;
        int m5 = 0;
        ugly[0] = 1;
        while (index <= n - 2) {
            while (ugly[index] >= ugly[m2] * 2) {
                m2++;             //找到第一个比当前最大丑数大的数字
            }
            while (ugly[index] >= ugly[m3] * 3) {
                m3++;
            }
            while (ugly[index] >= ugly[m5] * 5) {
                m5++;
            }
            ugly[++index] = min(ugly[m2] * 2, ugly[m3] * 3, ugly[m5] * 5);
        }
        return ugly[n - 1];
    }
    public int min(int a, int b, int c) {
        a = Math.min(a, b);
        return Math.min(a, c);
    }
}