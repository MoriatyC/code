class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> ret = new ArrayList<>();
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return ret;
        }
        int rowS = 0;
        int colS = 0;
        int row  = arr.length - 1;
        int col = arr[0].length - 1;
        while (rowS <= row && colS <= col) {
            //因为是按照顺时针方向进行打印，所以只要发现当前这一步无法进行打印，即说明程序结束
            for (int i = colS; i <= col; i++) {
                ret.add(arr[rowS][i]);
            }
            rowS++;
            if (rowS <= row) {
                for (int i = rowS; i <= row; i++) {
                    ret.add(arr[i][col]);
                }
                col--;
            } else {
                break;
            }
            if (col >= colS) {
                for (int i = col; i >= colS; i--) {
                    ret.add(arr[row][i]);
                }
                row--;
            } else {
                break;
            }          
            if (row >= rowS) {
                for (int i = row; i >= rowS; i--) {
                    ret.add(arr[i][colS]);
                }
                colS++;
            } else {
                break;
            }
            
        }
        return ret;
    }
}