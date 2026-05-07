class Solution {
    public int[] twoSum(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while(l < r) {

            int sum = nums[l] + nums[r];

            if (sum == target) {

                return new int[] {++l, ++r};
            }

            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[0];
        
    }
}
