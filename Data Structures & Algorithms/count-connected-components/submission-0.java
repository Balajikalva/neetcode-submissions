class Solution {
    public int countComponents(int n, int[][] data) {

     List<List<Integer>> edges = new ArrayList<>();

      for (int i = 0;i < n; i++) {

        edges.add(new ArrayList<>());
      }

      for (int[] arr : data) {

        edges.get(arr[0]).add(arr[1]);
        edges.get(arr[1]).add(arr[0]);

      }

      boolean[] seen = new boolean[n];
      int count = 0;

      for (int i = 0; i < n; i++) {

        if (!seen[i]) {
            bfs(edges, seen, i);
            count++;
        }
      }

      return count;

    }

    public void bfs(List<List<Integer>> edges,boolean[] seen, int start) {

    

        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        seen[start] = true;

        while(!que.isEmpty()) {

            int node = que.remove();

            for (int next : edges.get(node)) {

                if (seen[next]) continue;

                seen[next] = true;
                que.add(next);
            }
        }
    }
}
