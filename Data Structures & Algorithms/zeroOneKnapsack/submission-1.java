class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        
        return helper(profit, weight, capacity, 0, 0);
    }

    public int helper(List<Integer> profit, List<Integer> weight, int remaining, int ind, int max) {

        if (remaining == 0 || ind == profit.size()) {

            return max;
        }

        int w = weight.get(ind);
        int p = profit.get(ind);

        if (w <= remaining) {

            return Math.max(helper(profit, weight, remaining - w, ind + 1, max + p) , helper(profit, weight, remaining, ind + 1, max));
        }

        return helper(profit, weight, remaining, ind + 1, max);
    }
}
