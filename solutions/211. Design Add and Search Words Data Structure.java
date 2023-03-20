import java.util.Arrays;

class WordDictionary {

    private static class TrieNode {
        char character;
        TrieNode[] children;
        boolean isEndofWord;

        public TrieNode(char c) {
            this.character = c;
            this.children = new TrieNode[26];
            this.isEndofWord = false;

            Arrays.fill(children, null);
        }
    }

    private static class Trie {
        private TrieNode trieRootNode;

        public Trie() {
            this.trieRootNode = new TrieNode('\0');
        }

        public void add(String word) {
            char[] letters = word.toCharArray();
            TrieNode current = this.trieRootNode;
            for (char letter : letters) {
                int index = letter - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode(letter);
                }
                current = current.children[index];
            }
            current.isEndofWord = true;
        }

        public boolean search(TrieNode trieRootNode, String word) {
            TrieNode current = trieRootNode;
            if (current == null)
                return false;
            char[] letters = word.toCharArray();
            for (int index = 0; index < letters.length; index++) {
                char letter = letters[index];
                if (letter == '.') {
                    for (int ci = 0; ci < current.children.length; ci++) {
                        if (current.children[ci] == null)
                            continue;

                        if (search(current.children[ci], word.substring(index + 1)))
                            return true;
                    }
                } else {
                    int cindex = letter - 'a';
                    if (current.children[cindex] == null)
                        return false;
                    current = current.children[cindex];
                }
            }

            return (current != null) && current.isEndofWord;
        }

        private boolean searchUtil(WordDictionary.TrieNode current, String word) {
            return (word != null && word.length() > 0 && current != null) && search(current, word)
                    && current.isEndofWord;
        }
    }

    private Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.add(word);
    }

    public boolean search(String word) {
        return trie.search(trie.trieRootNode, word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
