class Solution {
​
    private class Edge {
        int source;
        int nbr;
​
        Edge(int s, int nbr) {
            this.source = s;
            this.nbr = nbr;
        }
    }
​
    private List<Edge>[] construct_graph(int[][] isConnected) {
        List<Edge>[] graph = new ArrayList[isConnected.length];
​
        for (int v = 0; v < isConnected.length; v++)
            graph[v] = new ArrayList<>();
​
        for (int v = 0; v < isConnected.length; v++) {
            for (int edge = 0; edge < isConnected[v].length; edge++) {
                if (isConnected[v][edge] == 0 || edge == v)
                    continue;
                graph[v].add(new Edge(v, edge));
            }
        }
​
        return graph;
    }
​
    public int findCircleNum(int[][] isConnected) {
        List<Edge>[] graph = construct_graph(isConnected);
​
        int components = 0;
        boolean[] visited = new boolean[isConnected.length];
​
        for (int vertex = 0; vertex < isConnected.length; vertex++) {
            if (visited[vertex] == false) {
                components++;
                __travel_provinces_count(graph, vertex, visited);
            }
        }
​
        return components;
    }
​
    private void __travel_provinces_count(List<Edge>[] graph, int vertex, boolean[] visited) {
        visited[vertex] = true;
​
        for (Edge edge : graph[vertex])
            if (visited[edge.nbr] == false)
                __travel_provinces_count(graph, edge.nbr, visited);
    }
}
