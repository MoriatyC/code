public class Solution {
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0] == null || array[0].length == 0) {
            return false;
        }
        int rows = array.length;
        int cols = array[0].length;
        int row = 0;
        int col = cols - 1;
         for (int i = col; i >= 0; i--) {
            for (int j = row; j < rows; j++) {
                if (array[j][i] > target) {
                    break;
                } else if (array[j][i] == target) {
                    return true;
                } else {
                    row++;
                }
            }
        }
        return false;
    }
}