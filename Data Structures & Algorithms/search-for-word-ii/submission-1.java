class Solution {

    Trie head = new Trie();
    int[][] neighs = {{0,1}, {0, -1}, {1,0}, {-1, 0}};

    class Trie {

        Trie[] children;

        Trie() {

            this.children = new Trie[26];
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        
        for (int i = 0;i < board.length; i++) {

            for (int j = 0;j < board[i].length; j++) {

                createTrie(board, i, j, head);
            }
        }

        List<String> sol = new ArrayList<>();

        for (String word : words) {

            if (search(head, word, 0)) {
                sol.add(word);
            }
        }

        return sol;
    }

    private void createTrie(char[][] board, int x, int y, Trie trie) {

        char ch = board[x][y];
        board[x][y] = '#';

        int num = ch - 'a';

        if (trie.children[num] == null) {
            trie.children[num] = new Trie();
        }


        for (int i = 0;i < 4; i++) {

            int nx = x + neighs[i][0];
            int ny = y + neighs[i][1];

            if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[nx].length || board[nx][ny] == '#') continue;
            createTrie(board, nx, ny, trie.children[num]);
        }

        board[x][y] = ch;
    }

    private boolean search(Trie trie, String word, int ind) {

        if (ind == word.length()) return true;
        int num = word.charAt(ind) - 'a';
        return trie.children[num] != null && search(trie.children[num], word, ind + 1);
    }
}
