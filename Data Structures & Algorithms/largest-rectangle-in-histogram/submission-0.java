class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int area = 0;

        for (int i = 0;i < heights.length; i++) {

            int width = 1;

            int l = i - 1;

            while(l >= 0 && heights[l] >= heights[i]) {
                width++;
                l--;
            }

            int r = i + 1;

            while(r < heights.length && heights[r] >= heights[i]) {

                width++;
                r++;
            }

            area = Math.max(area, heights[i] * width);
        }

        return area;
    }
}
