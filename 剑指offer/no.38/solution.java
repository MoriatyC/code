package first_maven;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main{
    public static int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        } 
        int first = findFirst(array, k, 0, array.length- 1);
        if (first == -1) {
            return 0;
        }
        int last = findLast(array, k, 0, array.length - 1);
        return last - first + 1;
    }
    public static int findFirst(int[] array, int k, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (array[mid] == k) {
            if (0 == mid || array[mid - 1] != k) {
                return mid;
            }
            return findFirst(array, k, left, mid - 1);
        }
        if (array[mid] > k) {
            return findFirst(array, k, left, mid - 1);
        }
        return findFirst(array, k, mid + 1, right);
    }
    public static int findLast(int[] array, int k, int left, int right) {
        if (left > right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        if (array[mid] == k) {
            if (array.length - 1 == mid || array[mid + 1] != k) {
                return mid;
            }
            return findLast(array, k, mid + 1, right);
        }
        if (array[mid] > k) {
            return findLast(array, k, left, mid - 1);
        }
        return findLast(array, k, mid + 1, right);
    }
    public static void main(String[] args) throws ParseException {
        int[] arr = {3,3,3,3,4,5};
        System.out.println(GetNumberOfK(arr, 13));
    }
}
