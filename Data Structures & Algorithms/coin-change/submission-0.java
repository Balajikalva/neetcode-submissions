class Solution {


    public int coinChange(int[] coins, int amount) {

        // Arrays.sort(coins);
        return helper(0, coins, amount);
    }

    private int helper(int ind, int[] coins, int remain) {

        if (remain == 0) return 0;

        if (ind == coins.length) {

            return -1;
        }

        int coin = coins[ind];

        int times =  0;
        int min = -1;

        while(remain >= 0) {

            int temp = helper(ind + 1, coins, remain);

            if (temp != -1) {

                if (min == -1 || min > times + temp) {

                    min = times + temp;
                }
            }

            remain -= coin;
            times++;

        }

        return min;

    }
}
