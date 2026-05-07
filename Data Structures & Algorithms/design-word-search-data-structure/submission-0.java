class WordDictionary {

    Trie head;

    class Trie {

        boolean isEnd;
        Trie[] children;

        Trie() {

            this.isEnd = false;
            this.children = new Trie[26];
        }
    }

    public WordDictionary() {

        this.head = new Trie();
    }

    public void addWord(String word) {

        Trie start = head;

        for (int i  = 0;i < word.length(); i++) {

            int num = word.charAt(i) - 'a';

            if (start.children[num] == null) {
                start.children[num] = new Trie();
            }

            start = start.children[num]; 
        }

        start.isEnd = true;
    }

    public boolean search(String word) {

        return search(word, 0, head);
    }

    private boolean search(String word, int ind, Trie trie) {


        if (ind == word.length()) {

            return trie.isEnd;
        }

        char ch = word.charAt(ind);

        if (ch != '.') {

            Trie next = trie.children[(int) (ch - 'a')];
            return next != null && search(word, ind + 1, next);
        }

        for (int i = 0;i < 26; i++) {

            Trie next = trie.children[i];

            if (next != null && search(word, ind + 1, next)) {
                return true;
            }
        }

        return false;
    }
}
