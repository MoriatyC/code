package prepare;
/** 
* @author : Menghui Chen 
* @version ：2018年3月23日 上午11:02:23 
* @Description:
*/
public class BinarySearch {
    public int getFirst(int[] arr, int left, int right, int k) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (arr[left] == k) {
            return left;
        }
        return -1;
    }
    public int getLast(int[] arr, int left, int right, int k) {
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid] <= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (arr[left] == k) {
            return left;
        }
        return -1;
    }
}
