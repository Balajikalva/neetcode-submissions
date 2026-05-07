class Solution {
    public List<Integer> topologicalSort(int n, int[][] connections) {
        
        int[] outConnections = new int[n];
        List<List<Integer>> edges = new ArrayList<>(n);
        int unTouchedNodes = n;
        List<Integer> sol = new ArrayList<>();

        for (int i = 0;i < n; i++) {
            edges.add(new ArrayList<>());
            sol.add(0);
        }

        for (int[] connection : connections) {

            int from = connection[0];
            int to = connection[1];

            edges.get(to).add(from);
            outConnections[from]++;
        }

        Queue<Integer> pq = new LinkedList<>();

        for (int i = 0;i < n; i++) {

            if (outConnections[i] == 0) {
                pq.add(i);
            }
        }

        while(unTouchedNodes > 0 && pq.size() > 0) {

            int node = pq.remove();
            sol.set(--unTouchedNodes, node);

            for (int next : edges.get(node)) {

                if (--outConnections[next] == 0) {
                    pq.add(next);
                }
            }
        }

        return unTouchedNodes == 0 ? sol : new ArrayList<>();
    }
}
