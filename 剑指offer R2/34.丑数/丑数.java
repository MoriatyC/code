public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        if (index == 1) {
            return 1;
        }
        int[] ugly = new int[index];
        ugly[0] = 1;
        int n2 = 0;
        int n3 = 0;
        int n5 = 0;
        for (int i = 1; i < index; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = n2; j < i; j++) {
                if (ugly[j] * 2 > ugly[i - 1]) {
                    min = ugly[j] * 2;
                    n2 = j;
                    break;
                }
            }
            for (int j = n3; j < i; j++) {
                if (ugly[j] * 3 > ugly[i - 1]) {
                    min = Math.min(ugly[j] * 3, min);
                    n3 = j;
                    break;
                }
            }
            for (int j = n5; j < i; j++) {
                if (ugly[j] * 5 > ugly[i - 1]) {
                    min = Math.min(ugly[j] * 5, min);
                    n5 = j;
                    break;
                }
            }
            ugly[i] = min;
        }
        return ugly[index - 1];
    }
}