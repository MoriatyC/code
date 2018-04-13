import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (input == null || input.length == 0 || k > input.length) {
            return ret;
        }
        sort(input, k - 1, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            ret.add(input[i]);
        }
        return ret;
    }
    public void sort(int[] arr, int k, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);
        if (pivot == k) {
            return;
        }
        if (pivot > k) {
            sort(arr, k, left, pivot - 1);
        } else {
            sort(arr, k, pivot + 1, right);
        }
    }
    public int partition(int[] arr, int left, int right) {
        Random random = new Random();
        int pivot = left + random.nextInt(right + 1 - left);
        int key = arr[pivot];
        swap(arr, left, pivot);
        while (left < right) {
            while (left < right && key <= arr[right]) {
                right--;
            }
            swap(arr, left, right);
            while (left < right && key > arr[left]) {
                left++;
            }
            swap(arr, left, right);
        }
        return left;
    }
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}