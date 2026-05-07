class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        return index(nums, 0, 0, target);
    }

    public int index(int[] nums, int ind,int sum,int target) {

        if (ind == nums.length) {

            if (sum == target) {

                return 1;
            }

            return 0;
        }

        return index(nums, ind + 1, sum + nums[ind], target) + index(nums, ind + 1, sum - nums[ind], target);
    }
}
