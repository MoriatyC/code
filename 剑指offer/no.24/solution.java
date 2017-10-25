public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return solution(sequence, 0, sequence.length - 1);
    }
    public   boolean solution(int[] arr, int left, int right) {

        if (left >= right) {
            return true;
        }
        int i = left;
        while (i < right) {
            if (arr[i] > arr[right]) {
                break;
            }
            i++;
        }
        for (int j = i; j < right; j++) {
            if (arr[j] < arr[right]) {
                return false;
            }
        }
        return solution(arr, left, i - 1) && solution(arr, i, right - 1);
    }
}