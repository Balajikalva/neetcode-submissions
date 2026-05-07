class Solution {

    HashMap<Integer, List<Pair>> edges = new HashMap<>();
    int[][] cost;
    boolean[][] seen;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        k++;
        fillEdges(n, k, flights);

        PriorityQueue<Triple> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.add(new Triple(src, 0, 0));

        for (int i = 0;i <= k; i++) {
            cost[src][i] = 0;
        }

        while(!pq.isEmpty()) {

            Triple current = pq.poll();

          if (current.steps == k) {
            continue;
          }
            seen[current.next][current.steps] = true;


            for (Pair pair : edges.get(current.next)) {

              if (seen[pair.node][current.steps + 1]) {
                continue;
              }

                if (cost[pair.node][current.steps + 1] > current.cost + pair.cost) {

                    cost[pair.node][current.steps + 1] = current.cost + pair.cost;
                    pq.add(new Triple(pair.node, current.steps + 1, current.cost + pair.cost));
                }
            }
        }

        int sol = Integer.MAX_VALUE;

        for (int i = 0;i <= k; i++) {

            if ( sol > cost[dst][i]) {
                sol = cost[dst][i];
            }
        }

        return sol == Integer.MAX_VALUE ? -1 : sol;

    }

    private void fillEdges(int n,int k, int[][] flights) {

        cost = new int[n][k + 1];
        seen = new boolean[n][k + 1];

        for (int i = 0; i < n;i++) {
            edges.put(i, new ArrayList<>());
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }

        for (int[] flight : flights) {

            int s = flight[0];
            int r = flight[1];
            int c = flight[2];

            List<Pair> list = edges.get(s);
            list.add(new Pair(r, c));
        }
    }

    static class Pair {

        int node;
        int cost;

        Pair(int node, int cost) {

            this.node = node;
            this.cost = cost;
        }
    }

    static class Triple {

        int next;
        int steps;
        int cost;

        Triple(int next, int steps, int cost) {

            this.next = next;
            this.steps = steps;
            this.cost = cost;
        }
    }

//    public static void main(String[] args) {
//
//        Solution sol = new Solution();
//        int[][] flights = {{0,1,2},{1,2,1},{2,0,10}};
//        int n = 3;
//        int src = 1;
//        int dest = 2;
//        int k = 1;
//
//        System.out.println(sol.findCheapestPrice(n,flights, src, dest, k));
//    }
}