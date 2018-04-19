//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
import java.util.*;
public class Solution {
    public void FindNumsAppearOnce(int [] arr,int num1[] , int num2[]) {
        int ret = 0;
        for (int i: arr) {
            ret ^= i;
        }
        int index = 0;
        while (ret != 0) {
            if ((ret & 1) == 1) {
                break;
            }
            index++;
            ret >>= 1;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i: arr) {
            if (((i >> index) & 1) == 1) {
                list1.add(i);
            } else {
                list2.add(i);
            }
        }
        ret = 0;
        for (int i: list1) {
            ret ^= i;
        }
        num1[0] = ret;
        ret = 0;
        for (int i: list2) {
            ret ^= i;
        }
        num2[0] = ret;
    }
}