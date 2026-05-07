class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> {

                return (b[0] * b[0]) + (b[1] * b[1]) - (a[0] * a[0]) - (a[1] * a[1]); 
            }
        );

        for (int[] point : points) {

            int distance = (point[0] * point[0]) + (point[1] * point[1]);
            pq.add(new int[] {point[0], point[1]});

            if (pq.size() > k) {
                pq.poll();
            } 
        }

        int[][] sol = new int[k][0];
        int ind = 0;

        while(pq.size() > 0) {

            sol[ind++] = pq.poll();
        }

        return sol;

    }
}
