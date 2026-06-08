class Solution {

    StringBuilder builder;

    public String foreignDictionary(String[] words) {

        this.builder = new StringBuilder();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0;i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0;i < words.length - 1; i++) {

            String first = words[i];
            String second = words[i + 1];

            int ind1 = 0;
            int ind2 = 0;

            while (ind1 < first.length() && ind2 < second.length()) {

                if (first.charAt(ind1) != second.charAt(ind2)) {

                    int from = first.charAt(ind1) - 'a';
                    int to = second.charAt(ind2) - 'a';

                    graph.get(from).add(to);

                    break;
                }

                ind1++;
                ind2++;
            }
        }

      //  System.out.println(graph);

        int[] seen = new int[26];

        for (int i = 0;i < seen.length; i++) {

            if (seen[i] == 2 || graph.get(i).isEmpty()) continue;

            if (!dfs(i, graph, seen)) {
                return "";
            }
        }

        return builder.reverse().toString();
    }

    private boolean dfs(int node, List<List<Integer>> graph, int[] seen) {

        seen[node] = 1;

        for (int next : graph.get(node)) {

            if (seen[next] == 1) {
                return false;
            }

            if (seen[next] == 0) {

                 if (!dfs(next, graph, seen)) {
                return false;
            }
            }
        }

        builder.append((char) (node + 'a'));
        seen[node] = 2;

        return true;
    }
}
