class Solution {
    public int maxArea(int[] heights) {
        
        int l = 0;
        int r = heights.length - 1;

        int max = 0;


        while(l < r) {

            int min;

            if (heights[l] < heights[r]) {
                min = heights[l];
                l++;
            }else {
                min = heights[r];
                r--;
            }

            if (max < min * (r - l + 1)) {
                max = min * (r - l + 1);
            }
        }

        return max;
    }
}
