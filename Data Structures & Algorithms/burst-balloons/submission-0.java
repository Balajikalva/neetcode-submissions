class Solution {
    public int maxCoins(int[] nums) {
        
        return helper(nums, nums.length);
    }

    public int helper(int[] nums,int left) {


        if (left == 0) return 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == -1) continue;

            int v1 = getLeft(nums, i - 1);
            int v2 = getRight(nums, i + 1);

            int temp = nums[i];
            nums[i] = -1;

            

            int sol = (temp * v1 * v2) + helper(nums, left - 1);

            // System.out.println(String.format("i : %d :: v1 : %d :: v2 : %d :: sol : %d", i, v1, v2,sol));

            nums[i] = temp;
            max = Math.max(sol, max);

        }

       return max;

    }

    public int getLeft(int[] nums, int ind) {

        while(ind >= 0) {

            if (nums[ind] != -1) return nums[ind];
            ind--;
        }

        return 1;
    }

    public int getRight(int[] nums, int ind) {

        while(ind < nums.length) {

            if (nums[ind] != -1) return nums[ind];
            ind++;
        }

        return 1;
    }
}
