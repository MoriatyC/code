package prepare;

import java.util.Random;

/** 
* @author : Menghui Chen 
* @version ：2018年3月11日 下午8:34:54 
* @Description:
*/
public class Sort {
    public static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
    public static int partition(int[] arr, int left, int right) {
        Random random = new Random();
        int pivot = left + random.nextInt(right - left + 1);
        int key = arr[pivot];
        swap(arr, left, pivot);
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            swap(arr, left, right);
            while (left < right && arr[left] < key) {
                left++;
            }
            swap(arr, left, right);
        }
        return right;
    }
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }
    
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    public static void merge(int[] arr, int left, int mid, int right) {
        int s1 = left;
        int s2 = mid + 1;
        int e1 = mid;
        int e2 = right;
        int [] tmp = new int[arr.length];
        int index = s1;
        while (s1 <= e1 && s2 <= e2) {
            if (arr[s1] < arr[s2]) {
                tmp[index++] = arr[s1++];
            } else {
                tmp[index++] = arr[s2++];
            }
        }
        while (s1 <= e1) {
            tmp[index++] = arr[s1++];
        }
        while (s2 <= e2) {
            tmp[index++] = arr[s2++];
        }
        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int index = arr.length - 1;
        while (index > 0) {
            for (int half = (index - 1) / 2; half >= 0; half--) {
                int left = 2 * half + 1;
                int right = 2 * half + 2;
                if (arr[half] < arr[left]) {
                    swap(arr, half, left);
                }
                if (right <= index && arr[half] < arr[right]) {
                    swap(arr, half, right);
                }
            }
            swap(arr, 0, index--);
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,5,32,54,65,3,53,87,4,31};
//      int[] arr = {1,2,3,4,2};
        heapSort(arr);
      for(int i: arr) {
          System.out.print(i + "  ");
      }
      System.out.println();
//      System.out.println("2  3  4  4  5  5  6  7  7  8  12  22  34  92  ");
    }
}
