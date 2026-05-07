class Solution {
    public int minimumSpanningTree(List<List<Integer>> connections, int n) {

        boolean[] seen = new boolean[n];
        List<List<int[]>> edges = new ArrayList<>(n);

        for (int i = 0;i < n; i++) {
            edges.add(new ArrayList<>());
        }

        for (List<Integer> connect : connections) {

            int n1 = connect.get(0);
            int n2 = connect.get(1);
            int w = connect.get(2);

            edges.get(n1).add(new int[] {n2, w});
            edges.get(n2).add(new int[] {n1, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        pq.add(new int[] {0,0});
        int count = 0;
        int res = 0;

        while(count < n && pq.size() > 0) {

            int[] current = pq.poll();

            // System.out.println(Arrays.toString(current));

            int node = current[0];
            int weight = current[1];

            if (seen[node]) continue;

            seen[node] = true;
            res += weight;
            count++;

            // System.out.println(String.format("count : %d and res : %d", count, res));

            for (int[] next : edges.get(node)) {

                if (seen[next[0]]) continue;
                pq.add(next);
            }
        }

        return count == n ? res : -1;
    }
}    
