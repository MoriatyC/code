public class Solution {
    public boolean checkRecord(String s) {
        int countA = 0, countL = 0;
        for(char c: s.toCharArray())
        {
            if(c == 'A')
            {
                if(countA == 1)
                    return false;
                else 
                    countA++;
            }
            if(c == 'L')
            {
                if(countL == 2)
                    return false;
                else
                {
                    countL++;
                }
            }
            else
            {
                countL = 0;
            }
        }
        return true;
    }
}