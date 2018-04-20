import java.util.*;
public class Solution {
    public boolean isContinuous(int [] num) {
		if (num == null || num.length != 5) {
            return false;
        }
        Arrays.sort(num);
        int count = 0;
        int index = 0;
        for (; index < num.length; index++) {
            if (num[index] == 0) {
                count++;
            } else {
                break;
            }
        }
        index++;
        for (; index < num.length; index++) {
            if (num[index] == num[index - 1]) {
                return false;
            }
            if (num[index] - num[index - 1] != 1) {
                count -= num[index] - num[index - 1] - 1;
                if (count < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}