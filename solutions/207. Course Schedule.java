class Solution {
    private enum NodeStatus { NOT_VISITED, IN_PROGRESS, VISITED };

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /**
         * concept based on DAG, if there exists a cycle answer is false
         * else cycle does not exist answer is true
         *
         * basically problem is to try to find a cycle
         */

        List<Integer>[] graph = getGraph(numCourses, prerequisites);

        NodeStatus[] visited = new NodeStatus[numCourses];
        Arrays.fill(visited, NodeStatus.NOT_VISITED);

        for (int node = 0; node < graph.length; node++) {
            if (visited[node] == NodeStatus.NOT_VISITED) {
                boolean result = exploreTheGraph(graph, node, visited);
                if (!result) return false;
            }
        }

        return true;
    }

    private boolean exploreTheGraph(List<Integer>[] graph, int source, NodeStatus[] visited) {
        if (visited[source] == NodeStatus.VISITED) return true;
        if (visited[source] == NodeStatus.IN_PROGRESS) return false;
        
        visited[source] = NodeStatus.IN_PROGRESS;
        // explore all adj nodes of the source
        for (int v : graph[source]) {            
            boolean rres = exploreTheGraph(graph, v, visited);
            if (!rres) return false;
        }
        visited[source] = NodeStatus.VISITED;
        return true;
    }

    private List<Integer>[] getGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();

        for (int[] nodes : prerequisites) {
            int u = nodes[0];
            int v = nodes[1];

            graph[u].add(v);
        }
        return graph;
    }
}
