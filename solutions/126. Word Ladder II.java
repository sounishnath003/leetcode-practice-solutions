// ## NOT Working Solution....
// Really Hard. but how I can apply BFS Algorithm.
// Getting No Clues ...........
​
​
class Solution {
​
    class Pair {
        String value;
        List<String> currentSeries;
​
        public Pair(String val, List<String> series) {
            this.value = val;
            this.currentSeries = new ArrayList<>(series);
        }
    }
​
    // Word Ladders - II
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (wordList == null || wordList.size() == 0) {
            return result;
        }
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (String word : wordList) {
            map.put(word, set);
        }
        map.put(beginWord, set);
        set.add(endWord);
        HashMap<String, HashSet<String>> map2 = new HashMap<>();
        HashSet<String> set2 = new HashSet<>();
        for (String word : wordList) {
            map2.put(word, set2);
        }
        map2.put(endWord, set2);
        List<String> currentSeries = new ArrayList<>();
        currentSeries.add(beginWord);
        Pair pair = new Pair(beginWord, currentSeries);
        List<String> nextSeries = new ArrayList<>();
​
        while (pair.currentSeries.size() > 0) {
            String word = pair.currentSeries.get(pair.currentSeries.size() - 1);
            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    String newWord = word.substring(0, i) + c + word.substring(i + 1, word.length());
                    if (map.containsKey(newWord)) {
                        if (map.get(newWord).contains(endWord)) {
                            List<String> list = new ArrayList<>(pair.currentSeries);
                            list.add(newWord);
                            result.add(list);
                            return result;
                        }
                        map.get(newWord).add(endWord);
                        map2.get(endWord).add(newWord);
                        nextSeries.add(newWord);
                    }
                }
            }
            pair.currentSeries.remove(pair.currentSeries.size() - 1);
            pair.currentSeries.addAll(nextSeries);
            nextSeries.clear();
        }
        return result;
    }
}
