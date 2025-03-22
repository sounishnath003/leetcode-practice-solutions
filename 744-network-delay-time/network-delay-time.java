class Solution {
    // https://leetcode.com/problems/network-delay-time/

    public int networkDelayTime(int[][] times, int n, int k) {
        // Build graph
        Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap<>();
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int wt = time[2];
            graph.computeIfAbsent(u, key -> new ArrayList<>()).add(new Pair<>(v, wt));
        }

        // 1-based indexing
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        pq.offer(new Pair<>(0, k));

        int[] costings = new int[n + 1];
        Arrays.fill(costings, Integer.MAX_VALUE);
        costings[k] = 0;

        Set<Integer> visited = new HashSet<>();

        int maxDelay = 0;

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();
            int costSoFar = pair.getKey();
            int node = pair.getValue();

            if (visited.contains(node)) {
                continue;
            }

            visited.add(node);

            if (graph.containsKey(node)) {
                for (Pair<Integer, Integer> neighborPair : graph.get(node)) {
                    int nei = neighborPair.getKey();
                    int wt = neighborPair.getValue();
                    if (costSoFar + wt < costings[nei]) {
                        costings[nei] = costSoFar + wt;
                        pq.offer(new Pair<>(costings[nei], nei));
                    }
                }
            }
        }

        if (visited.size() != n) {
            return -1;
        }

        for (int i = 1; i <= n; i++) {
            maxDelay = Math.max(maxDelay, costings[i]);
        }

        return maxDelay;
    }

    // Helper class for pairs
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}