import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] arr) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) {
            return ret;
        }
        int rowS = 0;
        int rowE = arr.length - 1;
        int colS = 0;
        int colE = arr[0].length - 1;
        while (rowS <= rowE && colS <= colE) {
            if (rowS <= rowE && colS <= colE) {
                for (int i = colS; i <= colE; i++) {
                    ret.add(arr[rowS][i]);
                }
                rowS++;
            }
            
            if (rowS <= rowE && colS <= colE) {
                for (int i = rowS;  i <= rowE; i++) {
                    ret.add(arr[i][colE]);
                }
                colE--;
            }
            if (rowS <= rowE && colS <= colE) {
                for (int i = colE;  i >= colS; i--) {
                    ret.add(arr[rowE][i]);
                }
                rowE--;
            }
            if (rowS <= rowE && colS <= colE) {
                for (int i = rowE;  i >= rowS; i--) {
                    ret.add(arr[i][colS]);
                }
                colS++;
            }
        }
        return ret;
    }
}