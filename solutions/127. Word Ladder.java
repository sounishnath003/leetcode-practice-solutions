class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
​
        // add wordlist into a hashset
        Set<String> set = new HashSet<>();
        set.addAll(wordList);
​
        // perform BFS
        Queue<Pair> q = new LinkedList<>();
​
        // push the begin word
        q.add(new Pair(beginWord, 1));
        // to mark the begin word has been used
        // delete from the set
        set.remove(beginWord);
​
        // iterate on the q
        while (!q.isEmpty()) {
            Pair wordEntry = q.poll();
            String word = wordEntry.word;
            int steps = wordEntry.steps;
            char[] wordChars = word.toCharArray();
​
            // WHEN FOUND
            if (word.equals(endWord)) {
                return steps;
            }
            // iterate on the words characters
            // as we need to run the check for all
            for (int i = 0; i < word.length(); i++) {
                char originalChar = wordChars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    wordChars[i] = c;
                    if (set.contains(String.valueOf(wordChars))) {
                        set.remove(String.valueOf(wordChars)); // remove to mark as visited
                        q.add(new Pair(String.valueOf(wordChars), steps + 1));
                    }
                }
                // backtrack to original character
                wordChars[i] = originalChar;
            }
        }
        return 0;
    }
    private class Pair{
        String word;
        int steps;
        Pair(String word, int steps){
            this.word = word;
            this.steps = steps;
        }
    }
}
​
