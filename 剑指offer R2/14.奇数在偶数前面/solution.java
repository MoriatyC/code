public class Solution {
    public void reOrderArray(int [] array) {
        if (array == null || array == null) {
            return;
        }
        int[] arr = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                arr[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 0) {
                arr[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = arr[i];
        }
    }
}