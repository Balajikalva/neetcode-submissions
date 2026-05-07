class Solution {

    int[][] dp;

    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        
        dp = new int[profit.size()][capacity + 1];
        return helper(profit, weight, capacity, 0, 0);
    }

    public int helper(List<Integer> profit, List<Integer> weight, int remaining, int ind, int max) {

        if (remaining == 0 || ind == profit.size()) {

            return max;
        }

        //if (dp[ind][remaining] != 0) return dp[ind][remaining];

        int w = weight.get(ind);
        int p = profit.get(ind);

        if (w <= remaining) {

            return dp[ind][remaining] = Math.max(helper(profit, weight, remaining - w, ind + 1, max + p) , helper(profit, weight, remaining, ind + 1, max));
        }

        return dp[ind][remaining] = helper(profit, weight, remaining, ind + 1, max);
    }
}
