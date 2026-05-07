class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> edges = getEdges(numCourses, prerequisites);

        int[] seen = new int[numCourses];

        for (int i = 0;i < numCourses; i++) {

            if (seen[i] == 0) {

                if (isCycle(i, edges, seen)) return false;
            }
        }

        return true;

    }

    public boolean isCycle(int start, List<List<Integer>> edges, int[] seen) {

        seen[start] = 1;

        for (int next : edges.get(start)) {

            if (seen[next] == 1) return true;
            if (seen[next] == 2) continue;

            if(isCycle(next, edges, seen)) {
                return true;
            }
        }

        seen[start] = 2;
        return false;
    }


    private List<List<Integer>> getEdges(int num, int[][] prerequisites) {

        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0;i < num; i++) {

            edges.add(new ArrayList<>());
        }

        for (int[] arr : prerequisites) {

            edges.get(arr[0]).add(arr[1]);
        }

        return edges;
    }
}
