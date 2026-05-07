class UnionFind {

    int[] parent;
    int[] rank;
    Set<Integer> set;

    public UnionFind(int n) {

        this.parent = new int[n];
        this.rank = new int[n];
        this.set = new HashSet<>();

        for (int i = 0;i < n; i++) {

            parent[i] = i;
            rank[i] = 1;
            set.add(i);
        }
    }

    public int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public boolean isSameComponent(int x, int y) {

        return find(x) == find(y);
    }

    public boolean union(int x, int y) {

        int px = find(x);
        int py = find(y);

        if (px == py) return false;

        if (rank[px] < rank[py]) {
            parent[px] = py;
            rank[py] += rank[px];
            set.remove(px);
        }else {
            rank[px] += rank[py];
            parent[py] = px;
            set.remove(py);
        }
        return true;
    }

    public int getNumComponents() {

        return set.size();
    }
}
