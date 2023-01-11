class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = buildGraph(edges, n);
        return dfs(graph, 0, -1, hasApple);
    }
​
    private int dfs(List<List<Integer>> graph, int node, int parent, List<Boolean> hasApple) {
        // TODO Auto-generated method stub
        int time = 0;
        for (int neighbor : graph.get(node)) {
            if (neighbor == parent)
                continue;
            int timeForChild = dfs(graph, neighbor, node, hasApple);
            if (timeForChild > 0 || hasApple.get(neighbor)) time += timeForChild + 2;
        }
​
        return time;
    }
​
    private List<List<Integer>> buildGraph(int[][] edges, int n) {
        // TODO Auto-generated method stub
        List<List<Integer>> graph = new ArrayList<>();
        for (int v = 0; v < n; v++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}
​
