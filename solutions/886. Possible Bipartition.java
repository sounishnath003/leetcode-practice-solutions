class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> graph = buildGraph(n, dislikes);
//          return isBipartite(graph);
​
        UnionFind uf = new UnionFind(n);
​
        for (int i = 1; i < n + 1; i++) {
            List<Integer> neighbors = graph.get(i);
            if (neighbors == null || neighbors.size() == 0)
                continue;
            int firstNeighbor = neighbors.iterator().next(); // gets the first item in the set
​
            for (int neighbor : neighbors) {
                if (uf.isConnected(i, neighbor))
                    return false; // if vertex i is connected with any of its neighbors, graph is not bipartite
                uf.union(firstNeighbor, neighbor); // unionize all its neighbors
            }
        }
​
        return true;
    }
​
    private static class UnionFind {
        int[] parent;
        int[] rank;
​
        public UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
​
            for (int i = 0; i < n + 1; i++) {
                parent[i] = i;
            }
        }
​
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
​
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    rank[rootX]++;
