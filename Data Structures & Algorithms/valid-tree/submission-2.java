class Solution {
    public boolean validTree(int n, int[][] data) {

      List<List<Integer>> edges = new ArrayList<>();

      for (int i = 0;i < n; i++) {

        edges.add(new ArrayList<>());
      }

      for (int[] arr : data) {

        edges.get(arr[0]).add(arr[1]);
        edges.get(arr[1]).add(arr[0]);

      }

      boolean[] seen = new boolean[n];

      if (isCyclic(edges, n-1,n, seen)) {
        return false;
      }

      for (int i = 0;i < n; i++) {

        if (!seen[i]) return false;
      }

      return true;

    }

    public boolean isCyclic(List<List<Integer>> edges, int start,int parent, boolean[] seen) {

      seen[start] = true;

      for (int next: edges.get(start)) {

        if (next == parent) continue;
        if (seen[next] || isCyclic(edges,next,start, seen)) return true;
      }

      return false;
    }
  }