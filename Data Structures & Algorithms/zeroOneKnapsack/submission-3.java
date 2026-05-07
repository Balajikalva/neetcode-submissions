class Solution {

    Integer[][] dp;

    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        
        dp = new Integer[profit.size()][capacity + 1];
        return helper(profit, weight, capacity, 0);
    }

    public int helper(List<Integer> profit, List<Integer> weight, int remaining, int ind) {

        if (remaining == 0 || ind == profit.size()) {

            return 0;
        }

        if (dp[ind][remaining] != null) return dp[ind][remaining];

        int w = weight.get(ind);
        int p = profit.get(ind);

        if (w <= remaining) {

            return dp[ind][remaining] = Math.max(p + helper(profit, weight, remaining - w, ind + 1) , helper(profit, weight, remaining, ind + 1));
        }

        return dp[ind][remaining] = helper(profit, weight, remaining, ind + 1);
    }
}
