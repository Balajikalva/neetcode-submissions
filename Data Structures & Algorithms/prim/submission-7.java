class Solution {
    public int minimumSpanningTree(List<List<Integer>> connections, int n) {

        List<List<Integer>> edges = new ArrayList<>();
        boolean[] optimised = new boolean[n];

        int res = 0;
        int count = 0;

        for (int i = 0;i < n; i++) {
            edges.add(new ArrayList<>());
        }

        for (List<Integer> connect : connections) {

            int n1 = connect.get(0);
            int n2 = connect.get(1);

            int w = connect.get(2);

            edges.get(n1).add(n2);
            edges.get(n1).add(w);

            edges.get(n2).add(n1);
            edges.get(n2).add(w);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[1] - b[1]
        );

        pq.add(new int[] {n-1, 0});

        while (pq.size() > 0) {

            int[] curr = pq.poll();

            int node = curr[0];
            int weight = curr[1];

            if (optimised[node]) continue;

            optimised[node] = true;
            res += weight;

            count++;

            List<Integer> nextList = edges.get(node);

            int len = nextList.size() / 2;

            for (int i = 0;i < len; i++) {

                int ind = (2 * i);

                int next = nextList.get(ind);
                int cost = nextList.get(ind + 1);

                if (optimised[next]) continue;
                pq.add(new int[] {next, cost});
            }

        }

        return count == n ? res : -1;
    }
}    
