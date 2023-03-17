    }
​
    public boolean search(String word) {
        char[] letters = word.toCharArray();
        TrieNode temporalRoot = this.root;
​
        for (char letter : letters) {
            int letterIndex = letter - 'a';
            if (temporalRoot.childrens[letterIndex] == null)
                return false;
            temporalRoot = temporalRoot.childrens[letterIndex];
        }
​
        return temporalRoot.isEndOfWord;
    }
​
    public boolean startsWith(String word) {
        char[] letters = word.toCharArray();
        TrieNode temporalRoot = this.root;
​
        for (char letter : letters) {
            int letterIndex = letter - 'a';
            if (temporalRoot.childrens[letterIndex] == null)
                return false;
            temporalRoot = temporalRoot.childrens[letterIndex];
        }
​
        return true;
    }
​
    @Override
    public String toString() {
        return "Trie [root=" + root + "]";
    }
}
​
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
