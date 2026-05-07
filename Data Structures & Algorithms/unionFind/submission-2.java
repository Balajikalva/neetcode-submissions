class UnionFind {

    int[] parent;
    int[] rank;
    int comp;

    public UnionFind(int n) {

        this.parent = new int[n];
        this.rank = new int[n];
        this.comp = n;

        for (int i = 0;i < n; i++) {

            parent[i] = i;
            rank[i] = 1;
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
        }else {
            rank[px] += rank[py];
            parent[py] = px;
        }

        comp--;
        return true;
    }

    public int getNumComponents() {

        return comp;
    }
}
