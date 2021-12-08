class Solution {
    private class FrequencyPair {
        int frequency;
        int data;
​
        public FrequencyPair(int frequency, int data) {
            this.frequency = frequency;
            this.data = data;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int elem : nums)
            map.put(elem, map.getOrDefault(elem,0) + 1);
​
        PriorityQueue<FrequencyPair> heap = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);
        for (int key : map.keySet()) {
            heap.offer(createFrequencyPair(map, key));
            if (heap.size() > k)
                heap.poll();
        }
​
        int[] result = new int[k];
        int counter = 0;
        while (!heap.isEmpty()){
            counter = pushDataIntoResult(heap, result, counter);
        }
        return result;
    }
​
    private int pushDataIntoResult(PriorityQueue<FrequencyPair> heap, int[] result, int counter) {
        result[counter] = heap.poll().data;
        counter++;
        return counter;
    }
​
    private FrequencyPair createFrequencyPair(HashMap<Integer, Integer> map, int key) {
        return new FrequencyPair(map.get(key), key);
    }
}
