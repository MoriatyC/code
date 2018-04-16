public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 5) {
            return index;
        }
        int[] arr = new int[index + 1];
        for (int i = 1; i <= 5; i++) {
            arr[i] = i;
        }
        int i2 = 1, i3 = 1, i5 = 1, i = 6;
        while (index + 1 != i) {
            int tmp = 0;
            for (; i2 < i; i2++) {
                if (arr[i2] * 2 > arr[i - 1]) {
                    tmp = arr[i2] * 2;
                    break;
                }
            }
            for (; i3 < i; i3++) {
                if (arr[i3] * 3 > arr[i - 1]) {
                    tmp = Math.min(tmp,arr[i3] * 3);
                    break;
                }
            }
            for (; i5 < i; i5++) {
                if (arr[i5] * 5 > arr[i - 1]) {
                    tmp = Math.min(tmp, arr[i5] * 5);
                    break;
                }
            }
            arr[i++] = tmp;
        }
        return arr[index];
    }
}