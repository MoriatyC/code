public class Solution {
    public boolean Find(int target, int [][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return false;
        }
        int row = arr.length - 1;
        int col = arr[0].length - 1;
        for (int i = col; i >= 0; i--) {
            for (int j = 0; j <= row; j++) {
                if (arr[j][i] == target) {
                    return true;
                } else if (arr[j][i] > target) {
                    break;
                }
            }
        }
        return false;
    }
}