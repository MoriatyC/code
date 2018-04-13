public class Solution {
    public int MoreThanHalfNum_Solution(int [] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int target = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (count == 0) {
                count++;
                target = arr[i];
            } else {
                if (arr[i] == target) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        count = 0;
        for (int i: arr) {
            if (i == target) {
                count++;
            }
        }
        return arr.length / 2 < count ? target : 0;
    }
}