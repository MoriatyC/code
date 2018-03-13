import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] arr) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) {
           return ret;
        }
        int rowLen = arr.length;
        int colLen =arr[0].length;
        int rowStart = 0;
        int rowEnd = rowLen - 1;
        int colStart = 0;
        int colEnd = colLen - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; rowStart <= rowEnd && colStart <= colEnd && i <= colEnd; i++) {
                ret.add(arr[rowStart][i]);
            }
            rowStart++;
            for (int i = rowStart; rowStart <= rowEnd && colStart <= colEnd && i <= rowEnd; i++) {
                ret.add(arr[i][colEnd]);
            }
            colEnd--;
            for (int i = colEnd; rowStart <= rowEnd && colStart <= colEnd && i >= colStart; i--) {
                ret.add(arr[rowEnd][i]);
            }
            rowEnd--;
            for(int i = rowEnd; rowStart <= rowEnd && colStart <= colEnd && i >= rowStart; i--) {
                ret.add(arr[i][colStart]);
            }
            colStart++;    
        }
        return ret;
    }
}