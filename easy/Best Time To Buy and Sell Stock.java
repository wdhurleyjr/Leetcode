class Solution {
    public int maxProfit(int[] prices) {
        int minValue = prices[0];
        int currentMax = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < minValue) {
                minValue = prices[i];
                continue;
            }
            int currentProfit = prices[i] - minValue;
            if(currentProfit > currentMax) {
                currentMax = currentProfit;
            }
        }
        return currentMax;
    }
}