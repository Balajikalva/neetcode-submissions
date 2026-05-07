class Solution {

    int ind;
    List<Integer> sol;

    public List<Integer> topologicalSort(int n, int[][] connections) {
        
        List<List<Integer>> edges  = new ArrayList<>();
        sol = new ArrayList<>(n);
        ind = n - 1;

        System.out.println("Sol :: " + sol);

        int[] seen = new int[n];

        for (int i = 0;i < n; i++) {
            edges.add(new ArrayList<>());
            sol.add(0);
        }

        for (int[] connection : connections) {

            edges.get(connection[0]).add(connection[1]);
        }

        for (int i = 0;i < n;i++) {

            if (seen[i] == 0) {

                if (dfs(i, seen, edges) == false) return new ArrayList<>();
            }
        }

        return sol;
    }

    private boolean dfs(int node, int[] seen, List<List<Integer>> edges) {

        seen[node] = 1;

        for (int next : edges.get(node)) {

            if (seen[next] == 2) continue;
            if (seen[next] == 1) return false;
            if (dfs(next, seen, edges) == false) return false;
        }

        seen[node] = 2;
        System.out.println(node+" " + ind);
        sol.set(ind, node);
        ind--;

        return true;
    }
}
