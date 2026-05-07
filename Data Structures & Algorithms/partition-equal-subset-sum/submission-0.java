class Solution {
    public boolean canPartition(int[] nums) {
        
        long total = 0L;

        for (int num : nums) {

            total += num;
        }

        if (total % 2 != 0) return false;

        // we have two choices at one place, take it or don't

        return helper(nums, 0, 0, total);

    }

    public boolean helper(int[] nums, int ind, long sum, long total) {

        if (sum + sum == total) return true;

        if (ind == nums.length) return false;

        return helper(nums, ind + 1, sum + nums[ind], total) || helper(nums, ind + 1, sum, total);
    }
}
