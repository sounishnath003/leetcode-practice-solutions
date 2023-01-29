class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> s = new HashSet<>();
        List<String> concatenateWords = new ArrayList<>();
        for(String word : words)
            s.add(word);
        for(String word : words) {
            if(checkConcatenate(word, s) == true)
                concatenateWords.add(word);
        }
        return concatenateWords;
    }
    public boolean checkConcatenate(String word, Set<String> s) {
        for(int i = 1; i < word.length(); i++) {
            String prefixWord = word.substring(0, i);
            String suffixWord = word.substring(i, word.length());
            if(s.contains(prefixWord) && (s.contains(suffixWord) || checkConcatenate(suffixWord, s)))
                return true;
        }
        return false;
    }
}
​
