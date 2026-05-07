class Solution {

    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {

        return helper(0, capacity, profit, weight);

    }

    private int helper(int ind, int capacity, List<Integer> profit, List<Integer> weight) {

        if (capacity == 0 || ind == profit.size()) {

            return 0;
        }

        int max = helper(ind + 1, capacity, profit, weight);

        int p = profit.get(ind);
        int w = weight.get(ind);
        int times = 0;

        while (capacity - w >= 0) {
            capacity -= w;
            max = Math.max(max, ((++ times) * p )+ helper(ind + 1, capacity, profit, weight));
        }

        return max;

    }
}