class WordFilter {
    private HashMap<String, Integer> cache =  new HashMap<>();
    /**
     * For a word like "test", consider "#test", "t#test", "st#test", "est#test",
     * "test#test". Then if we have a query like prefix = "te", suffix = "t", we can
     * find it by searching for something we've inserted starting with "t#te".
     */
    
    public WordFilter(String[] words) {
        String salt = "$@"; int wordIdx = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                for (int k = 0; k < words[i].length(); k++) {
                    String key = words[i].substring(0, j+1) + salt + words[i].substring(k);
                    cache.put(key, i);
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        String key = prefix+"$@"+suffix;
        return cache.getOrDefault(key, -1);
    }
}
​
/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
