public class Solution {
    public int MoreThanHalfNum_Solution(int [] arr) {
        if (arr == null || arr.length <= 0) {
            return 0;
        }
        int count = 1;
        int cur = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (count == 0) {
                cur = arr[i];
                count++;
            } else if (cur == arr[i]) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur == arr[i]) {
                count++;
            }
        }
        return count > arr.length / 2 ? cur : 0;
    }
}