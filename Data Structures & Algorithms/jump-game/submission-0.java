class Solution {
    public boolean canJump(int[] nums) {
        
        int maxReach = 0;

        for (int i = 0;i < nums.length; i++) {

            int num = nums[i];

            if (maxReach < i) return false;
            maxReach = Math.max(i + num, maxReach);
        }

        return true;
    }
}
