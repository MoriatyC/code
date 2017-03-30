public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> ret = new ArrayList();
        for(int h = 0; h < 12; h++)
        {
            for(int m = 0; m < 60; m ++)
            {
                if(Integer.bitCount(h * 64 + m) == num)
                {
                     ret.add(h + ":" + (m < 10 ? "0" + m : m));//faster
		  //ret.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return ret;
    }
        
}