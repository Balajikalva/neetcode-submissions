class Solution {
    public int maxProduct(int[] nums) {
        
        int sol = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length ; i++) {

            int product = nums[i];
            sol = Math.max(sol, product);
            
            // if (nums[i] == 0) {
            //     sol = Math.max(sol, product);
            //     continue;
            // }

            for (int j = i + 1; j < nums.length; j++) {

                // if (nums[j] == 0) break;

                product *=nums[j];
                sol = Math.max(product, sol);
            }
        }

        return sol;
    }
}
