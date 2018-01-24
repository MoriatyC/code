package first_maven;

public class Main {
    public static void findMaxMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i += 2) {
            if (i + 1 == arr.length) {
                max = Math.max(arr[i], max);
                min = Math.min(arr[i], min);
            } else {
                if (arr[i] <= arr[i + 1]) {
                    max = Math.max(max, arr[i + 1]);
                    min = Math.min(min, arr[i]);
                } else {
                    max = Math.max(max, arr[i]);
                    min = Math.min(min, arr[i + 1]);
                }
            }
        }
        System.out.println(max + "          " + min);
    }
    public static void main(String[] args) {
        findMaxMin(new int[]{1,2,3,4,5,6,312,4,2,2454,21,6,5,3,22});
    }
}