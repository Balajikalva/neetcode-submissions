class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int[][] neighs = {{0,1},{1,0},{0,-1},{-1,0}};

        int n = matrix.length;
        int m = matrix[0].length;

        List<List<Integer>> edges = new ArrayList<>();
        int[] seen = new int[n*m];

        for (int i = 0;i < n*m;i++) {

            edges.add(new ArrayList<>());
        }

        for (int i = 0;i < matrix.length; i++) {

            for (int j = 0;j < m;j++) {


                int val = matrix[i][j];

                int node = i * m + j;

                for (int k = 0; k < 4; k++) {

                    int nx = i + neighs[k][0];
                    int ny = j + neighs[k][1];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || matrix[nx][ny] <= val) continue;

                    int next = nx * m + ny;

                    edges.get(node).add(next);
                }
            }
        }

        int sol = 1;

        for(int i = 0;i < n*m; i++) {

            if (seen[i] == 0) {

                 int temp = dfs(edges,seen,i);
                 sol = Math.max(sol, temp);
            }
        }

        return sol;
    }

    private int dfs(List<List<Integer>> edges, int[] seen, int node) {

        if (seen[node] != 0) {
            return seen[node];
        }

        int max = 0;

        for (int next : edges.get(node)) {
            max = Math.max(max, dfs(edges, seen, next));
        }

        return seen[node] = 1 + max;
    } 
}
