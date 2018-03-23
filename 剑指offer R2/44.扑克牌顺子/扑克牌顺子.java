import java.util.*;
public class Solution {
    public boolean isContinuous(int [] numbers) {
		if (numbers == null || numbers.length != 5) {
            return false;
        }
        Arrays.sort(numbers);
        int count0 = 0;
        boolean start = false;
        int pre = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                count0++;
            } else {
                if (!start) {
                    start = true;
                    pre = numbers[i];
                } else {
                    if (numbers[i] - pre > 1) {
                        count0 -= numbers[i] - pre - 1;
                        pre = numbers[i];
                        if (count0 < 0) {
                            return false;
                        }
                    } else if (numbers[i] - pre == 1){
                        pre = numbers[i];
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
/*

		if (numbers == null || numbers.length != 5) {
            return false;
        }
        Arrays.sort(numbers);
        boolean start = false;
        int count0 = 0;
        int cur = 0;
        for (int i = 0; i < 5; i++) {
            if (!start) {//start = false 说明没找到不是0的
                if (numbers[i] != 0) {
                    count0 = i;
                    start = true;
                    cur = numbers[i] + 1;
                } 
            } else {
            	while (cur != numbers[i]) {
                    if (count0 > 0) {
                        count0--;
                        cur++;
                    } else {
                        return false;
                    }
                }
                cur++;
            }
        }
        return true;

*/