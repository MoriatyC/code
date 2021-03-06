package first_maven;

import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void combination(String s) {
        List<String> ret = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            combination(s, i, ret);
        }
    }
    public static void combination(String s, int m, List<String> result) {//从字符串中找长度为m的组合
        
        // 如果m==0，则递归结束。输出当前结果  
        if (m == 0) {  
            for (int i = 0; i < result.size(); i++) {  
                System.out.print(result.get(i));  
            }  
            System.out.println();  
            return;  
        }  
  
        if (s.length() != 0) {  
            // 选择当前元素  
            result.add(s.charAt(0) + "");  
            combination(s.substring(1, s.length()), m - 1, result);  
            result.remove(result.size() - 1);//注意：递归出栈时需要移除List中的字符组合  
            // 不选当前元素  
            combination(s.substring(1, s.length()), m, result);  
        }  
    }  
    public static void main(String[] args) {
        combination("abcd");
    }
}
