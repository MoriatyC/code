package prepare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/** 
* @author : Menghui Chen 
* @version ：2018年3月19日 上午10:23:14 
* @Description:
*/
public class Pailie {
    Set<String> ret = new HashSet<>();
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> ret0 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (str == null || str.length() == 0) {
            return ret0;   
        }
        char[] arr = str.toCharArray();
        helper(arr, sb, 0);
        for (String i: ret) {
            ret0.add(i);
        }
        Collections.sort(ret0);
        return ret0;
    }
    public void helper(char[] arr, StringBuilder sb, int index) {
        if (arr.length == index) {
            ret.add(sb.toString());
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            sb.append(arr[index]);
            helper(arr, sb, index + 1);
            swap(arr, index, i);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
