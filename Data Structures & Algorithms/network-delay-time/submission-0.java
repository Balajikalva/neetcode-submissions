class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<Integer>> edges = new ArrayList<>(n);

        for (int i = 0;i <= n; i++) {
            edges.add(new ArrayList<>());
        }


        for (int[] time : times) {

            int source = time[0];
            int target = time[1];
            int weight = time[2];

            edges.get(source).add(target);
            edges.get(source).add(weight);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[1] - b[1]
        );

        pq.add(new int[] {k, 0});

        boolean[] optimised = new boolean[n + 1];
        Integer[] cost = new Integer[n + 1];

        cost[k] = 0;

        while (pq.size() > 0) {

            int[] current = pq.poll();
            int node = current[0];
            int weight = current[1];

            if (optimised[node]) continue;

            optimised[node] = true;
            List<Integer> nodeEdges = edges.get(node);

            for (int i = 0;i < nodeEdges.size() / 2; i++) {

                int next = nodeEdges.get(i * 2);
                int time = nodeEdges.get((i * 2) + 1);

                if (!optimised[next] && (cost[next] == null || cost[next] > weight + time)) {
                    pq.add(new int[] {next, weight + time});
                    cost[next] = weight + time;
                }
            }
        }

        System.out.println(Arrays.toString(cost));

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {


            if (cost[i] == null) return -1;
            if (max < cost[i]) max = cost[i];
        }

        return max;
    }
}
