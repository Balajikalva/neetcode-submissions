class Solution {
    public int maxProfit(int[] prices) {
        
        return helper(prices, 0);
    }

    public int helper(int[] prices, int ind) {

        if (ind >= prices.length) return 0;

        int profit = helper(prices, ind + 1);

        for (int i = ind + 1; i < prices.length; i++) {

            if (prices[i] > prices[ind]) {

                profit = Math.max(profit, prices[i] - prices[ind] + helper(prices, i + 2));
            }
        }

        return profit;
    }
}
