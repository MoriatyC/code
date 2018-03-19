import java.util.*;

public class Solution {
    public String PrintMinNumber(int [] nums) {
        StringBuilder sb = new StringBuilder();
        if (nums == null || nums.length == 0) {
            return sb.toString();
        }
        String[] tmp = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(tmp, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String tmp1 = i + j;
                String tmp2 = j + i;
                return tmp1.compareTo(tmp2);
            }
        });
        for (String i: tmp) {
            sb.append(Integer.valueOf(i));
        }
        return sb.toString();
    }
}