import java.util.Arrays;

class Trie {

    static class TrieNode {
        char character;
        boolean isEndOfWord = false;
        TrieNode[] childrens;

        public TrieNode(char character, boolean isEndOfWord) {
            this.character = character;
            this.isEndOfWord = isEndOfWord;
            this.childrens = new TrieNode[26];
            Arrays.fill(this.childrens, null);
        }

        @Override
        public String toString() {
            return "TrieNode [character=" + character + ", isEndOfWord=" + isEndOfWord + ", childrens="
                    + Arrays.toString(childrens) + "]";
        }

    }

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode('\r', false);
    }

    public void insert(String word) {
        char[] letters = word.toCharArray();
        TrieNode temporalRoot = this.root;

        for (char letter : letters) {
            int letterIndex = letter - 'a';
            if (temporalRoot.childrens[letterIndex] == null) {
                temporalRoot.childrens[letterIndex] = new TrieNode(letter, false);
            }
            temporalRoot = temporalRoot.childrens[letterIndex];
        }

        temporalRoot.isEndOfWord = true;
    }

    public boolean search(String word) {
        char[] letters = word.toCharArray();
        TrieNode temporalRoot = this.root;

        for (char letter : letters) {
            int letterIndex = letter - 'a';
            if (temporalRoot.childrens[letterIndex] == null)
                return false;
            temporalRoot = temporalRoot.childrens[letterIndex];
        }

        return temporalRoot.isEndOfWord;
    }

    public boolean startsWith(String word) {
        char[] letters = word.toCharArray();
        TrieNode temporalRoot = this.root;

        for (char letter : letters) {
            int letterIndex = letter - 'a';
            if (temporalRoot.childrens[letterIndex] == null)
                return false;
            temporalRoot = temporalRoot.childrens[letterIndex];
        }

        return true;
    }

    @Override
    public String toString() {
        return "Trie [root=" + root + "]";
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
