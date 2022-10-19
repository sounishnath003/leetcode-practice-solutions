class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        WordsQueue wordsQueue = new WordsQueue();
        for (Map.Entry<String, Integer> kvPair : frequencyMap.entrySet()) {
            wordsQueue.add(kvPair);
            // normal heap logic for top = `K` results
            if (wordsQueue.size() > k) {
                wordsQueue.poll();
            }
        }
​
        while (!wordsQueue.isEmpty()) {
            Map.Entry<String, Integer> polled = wordsQueue.poll();
            result.add(polled.getKey());
        }
        // because result so far has ASC order in
        Collections.reverse(result);
​
        return result;
    }
​
    private class WordsQueue extends PriorityQueue<Map.Entry<String, Integer>> {
        public WordsQueue() {
            // min heap implication --
            super((a, b) -> {
                if (a.getValue() == b.getValue()) {
                    return b.getKey().compareTo(a.getKey());
                }
​
                return a.getValue() - b.getValue();
            });
        }
    }
}
