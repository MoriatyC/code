//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
import java.util.*;
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length == 0) {
            return;
        }
        int sum = 0;
        for (int i: array) {
            sum ^= i;
        }
        int index = 1;
        while (sum > 0) {
            if ((sum & 1) == 1) {
                break;
            }
            index++;
            sum = sum >> 1;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dispatcher(array, list1, list2, index);
        sum = 0;
        for (int i: list1) {
            sum ^= i;
        }
        num1[0] = sum;
        sum = 0;
        for (int i: list2) {
            sum ^= i;
        }
        num2[0] = sum;
    }
    public void dispatcher(int[] arr, List<Integer> list1, List<Integer> list2, int index) {
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            tmp = tmp >> (index - 1);
            if ((tmp & 1) == 1) {
                list1.add(arr[i]);
            } else {
                list2.add(arr[i]);
            }
        }
    }
}