class Solution {

    int[] connection;

    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        
        connection = new int[n+1];

        for (int i = 1;i <= n; i++) {

            connection[i] = i;
        }

        for (int[] edge : edges) {

            if (!union(edge[0], edge[1])) {

                return edge;
            }
        }

        return new int[0];

    }

    public int find(int node) {

        while(connection[node] != node) {

            node = connection[node];
        }

        return node;
    }

    public boolean union(int n1, int n2) {

        int c1 = find(n1);
        int c2 = find(n2);

        if (c1 == c2) return false;

        if (c1 < c2) {

            connection[c2] = c1;
            connection[n2] = n1;
        }else {

            connection[c1] = c2;
            connection[n1] = n2;
        }

        System.out.println(Arrays.toString(connection));

        return true;
    }
}
