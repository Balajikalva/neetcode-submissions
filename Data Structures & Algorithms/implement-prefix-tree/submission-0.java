class PrefixTree {

    Trie head;

    class Trie {

        boolean isEnd;
        Trie[] children;

        Trie() {

            this.isEnd = false;
            this.children = new Trie[26];
        }
    }

    public PrefixTree() {
         
         this.head = new Trie();
    }

    public void insert(String word) {

        Trie start = head;
        
        for (int i = 0;i < word.length(); i++) {

            int num = word.charAt(i) - 'a';

            if (start.children[num] == null) {

                start.children[num] = new Trie();
            }

            start = start.children[num];

        }

        start.isEnd = true;
    }

    public boolean search(String word) {

         Trie start = head;
        
        for (int i = 0;i < word.length(); i++) {

            int num = word.charAt(i) - 'a';

            if (start.children[num] == null) {

                return false;
            }

            start = start.children[num];

        }

        return start.isEnd;

    }

    public boolean startsWith(String word) {

        Trie start = head;
        
        for (int i = 0;i < word.length(); i++) {

            int num = word.charAt(i) - 'a';

            if (start.children[num] == null) {

                return false;
            }

            start = start.children[num];

        }

        return true;
    }
}
