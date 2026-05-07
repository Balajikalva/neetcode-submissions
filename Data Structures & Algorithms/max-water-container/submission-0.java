class Solution {
    public int maxArea(int[] heights) {
        

        int area = 0;

        int l = 0;
        int r = heights.length - 1;

        while(l <= r) {

            int left = heights[l];
            int right = heights[r];

            area = Math.max((r- l) * Math.min(left, right), area);

            if (left == right) {
                l++;
                r--;
            }else if(left < right) {
                l++;
            }else {
                r--;
            }
        }

        return area;
    }
}
