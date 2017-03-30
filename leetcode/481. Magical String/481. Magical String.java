public class Solution {
    public int magicalString(int n) {
        if(n <= 0) return 0;
        if(n <=3) return 1;
        int[] s = new int[n + 1];
        s[2] = 2;
        int index = 2, ret = 1, tail = 3;
        int cur = 0;
        int temp = 2;
        while(tail < n)
        {
            temp ^= 3;
            cur = s[index];
            while(cur > 0)
            {
                if(temp == 1 && tail < n) 
                {
                    ret++;
                }
                s[tail++] = temp;
                cur--;
            }
            
            index++;
        }

        return ret;
    }
}