class Solution {

    int[] sol;
  int[] seen;
  int ind;
  List<List<Integer>> edges;

  public int[] findOrder(int numCourses, int[][] prerequisites) {

    seen = new int[numCourses];
    sol = new int[numCourses];
    edges = new ArrayList<>();
    ind = 0;

    for (int i = 0;i < numCourses; i++) {

      edges.add(new ArrayList<>());
    }


    for (int[] arr : prerequisites) {

      edges.get(arr[0]).add(arr[1]);
    }

    for (int i  = 0;i < numCourses; i++) {

      if (seen[i] != 2) {

        if (dfs(i))  return new int[0];
      }
    }

    return sol;

  }

  private boolean dfs(int node) {

    seen[node] = 1;

    for (int next : edges.get(node)) {

      if (seen[next] == 2) continue;
      if (seen[next] == 1 || dfs(next)) return true;

    }

    seen[node] = 2;
    // System.out.println(node+" __ " + ind);
    sol[ind++] = node;

    return false;
  }

}
