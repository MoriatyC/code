import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (input == null || input.length == 0 || k < 1 || k > input.length) {
            return ret;
        }
        return helper(input, k, 0, input.length - 1, ret);
        
    }
    public ArrayList<Integer> helper(int[] input, int k, int left, int right, ArrayList<Integer> ret) {
        int pivot = partition(input, left, right);
        if (left > right || pivot + 1== k) {
            for (int i = 0; i < k; i++) {
                ret.add(input[i]);
            }
            return ret;
        } else if (pivot + 1 > k) {
            return helper(input, k, left, pivot - 1,  ret);
        } else {
            return helper(input, k, pivot + 1, right,  ret);
        }
    }
    public int partition(int[] arr, int left, int right) {
        Random random = new Random();
        int pivot = left + random.nextInt(right - left + 1);
        int key = arr[pivot];
        swap(arr, left, pivot);
        while (left < right) {
            while (left < right && arr[right] > key) {
                right--;
            }
            swap(arr, left, right);
            while (left < right && arr[left] <= key) {
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