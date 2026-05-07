class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> connections, int src) {

        Map<Integer,Integer> cost = new HashMap<>();
        boolean[] seen = new boolean[n];

        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0;i < n;i++) {

            edges.add(new ArrayList());
            seen[i] = false;
            cost.put(i, -1);

        }

        for (List<Integer> connect : connections) {

            int from = connect.get(0);
            int to = connect.get(1);
            int w =  connect.get(2);

            edges.get(from).add(to);
            edges.get(from).add(w);
        }

        cost.put(src, 0);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        pq.add(new int[] {src, 0});

        while (pq.size() > 0) {

            int[] curr = pq.poll();
            int node = curr[0];
            int w = curr[1];

            if (seen[node]) continue;
            seen[node] = true;

            List<Integer> nextList = edges.get(node);

            int len = nextList.size() / 2;

            for (int i = 0; i < len; i++) {

                int ind = 2 * i;

                int next = nextList.get(ind);
                int weight = nextList.get(ind + 1);

                if (seen[next]) continue;

                int nextCost = cost.get(next);

                if (nextCost == -1 || nextCost > w + weight) {

                    cost.put(next, w + weight);
                    pq.add(new int[] {next, w + weight});
                }
            }
        }

        return cost;
    }  
}
