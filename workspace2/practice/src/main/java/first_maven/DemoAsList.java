package first_maven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DemoAsList {

    public static void main(String[] args) throws InterruptedException {
        int[] a_int = { 1, 2, 3, 4 };  
        /* 预期输出应该是1,2,3,4,但实际上输出的仅仅是一个引用, 这里它把a_int当成了一个元素 */  
        List a_int_List = Arrays.asList(a_int);  
        System.out.println("11111111111111111111");
        foreach(a_int_List);  
        /* 为此我们需要这样遍历其中元素 */  
        System.out.println("22222222222222222222");
        foreachForBase(a_int_List);  
  
        /* 段落二:对象类型的数组使用asList,是我们预期的 */  
        Integer[] a_Integer = new Integer[] { 1, 2, 3, 4 };  
        List a_Integer_List = Arrays.asList(a_Integer);  
        System.out.println("333333333333333333333");
        foreach(a_Integer_List);  
   
        /* 段落三:当更新数组或者asList之后的List,另一个将自动获得更新 */  
        a_Integer_List.set(0, 0);  
        System.out.println("same");
        foreach(a_Integer_List);  
        foreach(a_Integer);  
        System.out.println("change");
        a_Integer[0] = 5;  
        foreach(a_Integer_List);  
        foreach(a_Integer);  
  
        /* 段落四:对基本类型数组,通过asList之后的List修改对应的值后,在运行时会报出异常  
         * 但是基本类型数组对应的List是会发生变化的,这是毫无疑问的 
         */  
          
        /* 
         * a_int_List.set(0, 0);  
         * foreach(a_int_List); foreach(a_int); 
         */  
        System.out.println("aaaaaaaaaaaaa");
        a_int[0] = 5;  
        foreachForBase(a_int_List);  
        foreach(a_int);  
    }
    private static void foreach(List list) {  
        for (Object object : list) {  
            System.out.print(object + " ");  
        }  
        System.out.println();  
  
    }  
  
    private static void foreachForBase(List a_int_List) {  
        int[] _a_int = (int[]) a_int_List.get(0);  
        foreach(_a_int);  
    } 
    private static void foreach(int[] a_int) {  
        for (int i : a_int) {  
            System.out.print(i + " ");  
        }  
        System.out.println();  
    }  
  
    private static void foreach(Integer[] _a_Integer) {  
        for (int i : _a_Integer) {  
            System.out.print(i + " ");  
        }  
        System.out.println();  
    }  
}