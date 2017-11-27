import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (array == null || array.length <= 1) {
            return ret;
        }
        int left = 0;
        int right = array.length - 1;
        while (left != right) {
            int cur = array[left] + array[right];
            if (cur == sum) {
                ret.add(array[left]);
                ret.add(array[right]);
                break;
            } else if (cur > sum) {
                right--;
            } else {
                left++;
            }
        }
        return ret;
    }
}