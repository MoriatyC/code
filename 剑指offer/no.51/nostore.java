import java.util.Arrays;
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int num[],int length,int [] duplication) {
        //当遇到一个新数字的时候，首先判断他和自己下标是否相等，if  yes，继续，否则调整至下标等于自己的地方
		if (num == null || length <= 0) {
			return false;
		}
        for (int i = 0; i < length; i++) {
            int cur = num[i];
            while (cur != i) {
                if (num[cur] == cur) {
                    duplication[0] = cur;
                    return true;
                }               
                num[i] = num[cur];
                num[cur] = cur;
                cur = num[i];
            }
        }
        return false;
    }
}