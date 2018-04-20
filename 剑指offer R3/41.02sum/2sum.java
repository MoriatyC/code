import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] arr,int sum) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (arr == null || arr.length < 2) {
            return ret;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] == sum) {
                ret.add(arr[left]);
                ret.add(arr[right]);
                break;
            } else if (arr[left] + arr[right] > sum) {
                right--;
            } else {
                left++;
            }
        }
        return ret;
    }
}