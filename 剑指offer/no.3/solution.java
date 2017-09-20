package first_maven;

public class Main {  
    public static boolean solution(int[][] arr, int target) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = arr[0].length - 1;
        while (col >= 0 && row <= arr.length - 1) {
            if (arr[row][col] == target) {
                return true;
            } else if (arr[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(solution(arr, 15));
    }
}