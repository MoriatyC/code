package first_maven;

import java.util.LinkedHashMap;

public class Main {
    public static  int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0; 
        int right = array.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (array[left] < array[right]) {
                return array[left];
            }
            if (array[mid]  > array[left]) {
                left = mid + 1;
            } else if (array[mid] < array[left]){
                if (mid > 1 && array[mid] < array[mid - 1]) {
                    return array[mid];
                }
                right = mid - 1;
            } else {
                return help(array, left, right);
            }
        }
        return array[left];
    }
    public static  int help(int[] arr, int left, int right) {
        int ret = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            ret = Math.min(ret, arr[i]);
        }
        return ret;
    }
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(NumberOf1(3));
    }
}