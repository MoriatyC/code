public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1 || prices == null) return 0;
        int min = prices[0];
        int ret = 0;
        for(int i = 1; i < prices.length; i++)
        {
            if(prices[i] < min) min = prices[i];
            if(prices[i] - min > ret) ret = prices[i] - min;
        }
        return ret;
    }
}