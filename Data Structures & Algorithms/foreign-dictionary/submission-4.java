class Solution {

    StringBuilder builder;

    public String foreignDictionary(String[] words) {

        builder = new StringBuilder();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] exists = new boolean[26];

        // collect all characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                exists[c - 'a'] = true;
            }
        }

        for (int i = 0; i < words.length - 1; i++) {

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

            // INVALID PREFIX CASE
            if (ind2 == second.length()
                    && ind1 < first.length()) {
                return "";
            }
        }

        int[] seen = new int[26];

        for (int i = 0; i < 26; i++) {

            if (!exists[i]) {
                continue;
            }

            if (seen[i] == 0) {

                if (!dfs(i, graph, seen)) {
                    return "";
                }
            }
        }

        return builder.reverse().toString();
    }

    private boolean dfs(int node,
                        List<List<Integer>> graph,
                        int[] seen) {

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

        seen[node] = 2;
        builder.append((char) (node + 'a'));

        return true;
    }
}