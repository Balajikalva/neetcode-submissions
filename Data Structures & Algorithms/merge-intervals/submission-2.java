class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][0];
        }
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> sol = new ArrayList<>();
        int[] choosenInterval = intervals[0];

        for (int i = 1;i < intervals.length; i++) {

            int[] interval = intervals[i];

            if (choosenInterval[1] >= interval[0]) {
                choosenInterval[1] = Math.max(choosenInterval[1], interval[1]);
            }else {
                sol.add(choosenInterval);
                choosenInterval = interval;
            }
        }

        sol.add(choosenInterval);

        int[][] ans = new int[sol.size()][0];

        for (int i = 0;i < sol.size(); i++) {
            ans[i] = sol.get(i);
        }

        return ans;
    }
}
