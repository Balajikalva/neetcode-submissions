class Solution {

    Integer[][] dp;

    public int change(int amount, int[] coins) {

        dp = new Integer[coins.length][amount + 1];
        
        return helper(coins, amount, 0);
    }

    public int helper(int[] coins, int amount, int ind) {

        if (amount == 0) return 1;
        if (amount < 0 || ind == coins.length) return 0;

        if (dp[ind][amount] != null) return dp[ind][amount];

        return dp[ind][amount] = helper(coins, amount - coins[ind], ind) + helper(coins, amount, ind + 1);
    }
}
