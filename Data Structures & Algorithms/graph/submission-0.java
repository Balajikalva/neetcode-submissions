class Graph {

    HashMap<Integer,Set<Integer>> edges;

    public Graph() {

        edges = new HashMap<>();
    }

    public void addEdge(int src, int dst) {

        Set<Integer> set = edges.getOrDefault(src, new HashSet<>());
        set.add(dst);
        edges.put(src, set);
    }

    public boolean removeEdge(int src, int dst) {

        if (edges.containsKey(src) && edges.get(src).contains(dst)) {

            edges.get(src).remove(dst);
            return true;
        }

        return false;
    }

    public boolean hasPath(int src, int dst) {

        Set<Integer> seen = new HashSet<>();

        Queue<Integer> que = new LinkedList<>();

        que.add(src);

        while (que.size() > 0) {

            int len = que.size();

            for (int i = 0;i < len;i++) {

                int node = que.remove();

                if (seen.contains(node) || !edges.containsKey(node)) continue;
                seen.add(node);

                for (Integer next : edges.get(node)) {
                    if (next == dst) return true;
                    if (seen.contains(next)) continue;
                    que.add(next);
                }
            }
        }

        return false;
    }
}
