class Solution {
    public int trap(int[] height) {

        int sol = 0;
        
        for (int i = 1; i < height.length - 1;i++) {

            int num = height[i];
            int leftMax = 0;

            for (int l = 0;l < i;l++) {
                leftMax = Math.max(leftMax, height[l]);
            }

            int rightMax = 0;

            for (int r = height.length - 1; r > i; r--) {

                rightMax = Math.max(rightMax, height[r]);
            }

            // System.out.println(String.format("num : %d, leftMax : %d, rightMax : %d", num, leftMax, rightMax));

            int store = (Math.min(leftMax, rightMax) - num);

            if (store > 0) sol += store;
        }

        return sol;
    }
}
