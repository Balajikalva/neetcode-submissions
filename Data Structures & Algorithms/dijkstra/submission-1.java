class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> connections, int src) {

        List<List<Pair>> edges = new ArrayList<>();
        Map<Integer,Integer> distances = new HashMap<>();
        boolean[] optimise = new boolean[n];

        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
            distances.put(i, -1);
        }

        for (List<Integer> connection : connections) {

            int from = connection.get(0);
            int to = connection.get(1);
            int w = connection.get(2);

            edges.get(from).add(new Pair(to, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.w - b.w
        );


        pq.add(new Pair(src,0));
        distances.put(src,0);


        while(pq.size() > 0) {

            Pair pair = pq.poll();

            int node = pair.n;
            int weight = pair.w;

            optimise[node] = true;

            for (Pair connection : edges.get(node)) {

                int next = connection.n;
                int cost = weight + connection.w;

                if (optimise[next]) continue;

                int prsCost = distances.get(next);

                if (prsCost == -1 || prsCost > cost) {

                    distances.put(next, cost);
                    pq.add(new Pair(next, cost));
                }
            }
        }

        return distances;

    }

    private static class Pair  {

        int n;
        int w;

        public Pair(int n, int w) {

            this.n = n;
            this.w = w;
        }
    }
}
