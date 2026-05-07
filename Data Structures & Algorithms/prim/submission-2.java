class Solution {

    int[] parent;
    int[] rank;

    public int minimumSpanningTree(List<List<Integer>> edges, int n) {

        parent = new int[n];
        rank = new int[n];

        for (int i = 0;i < n; i++) {
            
            parent[i] = i;
            rank[i] = 1;
        }   

        int sum = 0;
        int count = 0;

        edges.sort(Comparator.comparingInt(a -> a.get(2)));

        for (List<Integer> list : edges) {

            int n1 = list.get(0);
            int n2 = list.get(1);
            int w = list.get(2);

            if (count < n && union(n1, n2)) {
                count++;
                sum += w;
            }
        }

        return count == n - 1 ? sum : -1;
    }

    private int find(int node) {

        while (node != parent[node]) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }

        return node;
    }

    private boolean union(int n1, int n2) {

        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 == p2) {
            return false;
        }

        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }

        return true;
    }
}    
