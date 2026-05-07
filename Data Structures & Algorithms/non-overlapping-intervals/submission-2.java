class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals,(a, b) -> a[0] - b[0]);
        return intervals.length - helper(intervals, 0, Integer.MIN_VALUE);
    }

    private int helper(int[][] intervals, int ind, int max) {

        if (ind == intervals.length) return 0;

        // two choices one to choose and other not to

        int ans = helper(intervals, ind + 1, max);

        int[] interval = intervals[ind];

        if (interval[0] >= max) {

            ans = Math.max(ans, 1 + helper(intervals, ind, interval[1]));
        }

        return ans;
    }
}
