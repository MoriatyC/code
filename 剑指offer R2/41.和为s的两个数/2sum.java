import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] arr,int sum) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int cur = arr[left] + arr[right];
            if (cur == sum) {
                list.add(arr[left]);
                list.add(arr[right]);
                break;
            } else if (cur < sum) {
                left++;
            } else {
                right--;
            }
        }
        return list;
    }
}