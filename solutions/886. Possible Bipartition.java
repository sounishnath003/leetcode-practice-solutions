class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> graph = buildGraph(n, dislikes);
//			return isBipartite(graph);

        UnionFind uf = new UnionFind(n);

        for (int i = 1; i < n + 1; i++) {
            List<Integer> neighbors = graph.get(i);
            if (neighbors == null || neighbors.size() == 0)
                continue;
            int firstNeighbor = neighbors.iterator().next(); // gets the first item in the set

            for (int neighbor : neighbors) {
                if (uf.isConnected(i, neighbor))
                    return false; // if vertex i is connected with any of its neighbors, graph is not bipartite
                uf.union(firstNeighbor, neighbor); // unionize all its neighbors
            }
        }

        return true;
    }

    private static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];

            for (int i = 0; i < n + 1; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    rank[rootX]++;
                    parent[rootY] = rootX;
                } else {
                    rank[rootY]++;
                    parent[rootX] = rootY;
                }
            }
        }

        public int find(int x) {
            if (parent[x] == x)
                return x;

            int root = find(parent[x]);
            parent[x] = root; // path compression
            return root;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public boolean isBipartite(Map<Integer, List<Integer>> graph) {
        // Array representing the colors
        int[] colors = new int[graph.size()];

        // DFS of each node
        for (int i = 1; i < graph.size(); i++) {
            // If uncolored, then perform DFS
            if (colors[i] == 0 && !hasEvenCycle(graph, colors, i, 1))
                return false;
        }

        return true;
    }

    // Return true when graph is bipartite
    public boolean hasEvenCycle(Map<Integer, List<Integer>> graph, int[] colors, int node, int c) {
        // if node is colored, node color is same as sent in func definition, return
        // true
        if (colors[node] != 0)
            return colors[node] == c;

        // Color the current node with color sent in func definition
        colors[node] = c;

        // Check for all the adjecent nodes of the current node "node"
        for (int n : graph.get(node)) {
            if (!hasEvenCycle(graph, colors, n, -c))
                return false;
        }

        return true;

    }

    private Map<Integer, List<Integer>> buildGraph(int n, int[][] dislikes) {
        // TODO Auto-generated method stub
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : dislikes) {
            int u = edge[0];
            int v = edge[1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}
