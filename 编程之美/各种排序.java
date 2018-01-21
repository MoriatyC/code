package first_maven;

import java.util.Random;

public class Main {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void bubbleSort(int[] arr, int length) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        boolean changed = false;
        for (int i = 0; i < length - 1; i ++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    changed = true;
                }
            }
            if(!changed) {
                return;
            }
        }
    }
    public static void selectionSort(int[] arr, int length) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            int max = Integer.MIN_VALUE;
            int index = 0;
            for (int j = 0; j <= length - 1 - i; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    index = j;
                }
            }
            swap(arr, index, length - 1 - i);
        }
    }
    public static void insertSort(int[] arr, int length) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 1; i < length; i++) {
            int cur = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < cur) {
                    arr[j + 1] = cur;
                    break;
                } else {
                    arr[j + 1] = arr[j];
                    if (j == 0) {
                        arr[0] = cur;
                    }
        
                }
            }
        }
    }
    public static void shellSort(int[] arr, int length) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < length; i++) {
                int cur = arr[i]; 
                int j = i - gap;
                while (j >=0 && arr[j] > cur) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = cur;
            }
        }
    }
    public static void mergeSort(int[] arr, int left, int right) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    public static int[] merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[arr.length];
        int start = 0;
        int sleft = left;
        int sright = mid + 1;
        while (sleft <= mid && sright <= right) {
            if (arr[sleft] < arr[sright]) {
                tmp[start++] = arr[sleft++];
            } else {
                tmp[start++] = arr[sright++];
            }
        }
        while (sleft <= mid) {
            tmp[start++] = arr[sleft++];  
        }
        while (sright <= right) {
            tmp[start++] = arr[sright++];
        }
        start = 0;
        for (int i = left; i <= right; i++) {
            arr[i] = tmp[start++];
        }
        return arr;
    }
    public static void heapSort(int[] arr, int length) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int size = length;
        while (size > 1) {
            for (int i = size / 2; i>= 1; i--) {//一次for循环之后最大元素就在顶上
                int left = 2 * i - 1;
                int right = 2 * i;
                if (arr[left] > arr[i - 1]) {
                    swap(arr, left, i - 1);
                }
                if (right < size && arr[right] > arr[i - 1]) {
                    swap(arr, right, i - 1);
                }
            }
            swap(arr, 0, size - 1);
            --size;
        }
        
    }
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);
        quickSort(arr,left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }
    static  int r(int left, int right) {
        Random r = new Random();
        return r.nextInt(right - left + 1) +left;
    }
    public static int partition(int[] arr, int left, int right) {
        int random = r(left, right);
        swap(arr, left, random);
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] < key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }
    public static int partition2(int[] arr, int left, int right) {
        int random = r(left, right);
        swap(arr, random, right);
        int small = left - 1;
        for (int i = left; i < right; i++) {
            if (arr[i] < arr[right]) {
                swap(arr, ++small, i);
            }
        }
        swap(arr, ++small, right);
        return small;
    }
    public static void main(String[] args) {
//        int[] arr = {5,4,7,8,92,3,5,12,6,7,4,2,34,22};
      int[] arr = {3,5,32,54,65,3,53,87,4,31};
//        int[] arr = {1,2,3,4,2};
        quickSort(arr, 0, arr.length - 1);
        for(int i: arr) {
            System.out.print(i + "  ");
        }
        System.out.println();
//        System.out.println("2  3  4  4  5  5  6  7  7  8  12  22  34  92  ");
    }
}