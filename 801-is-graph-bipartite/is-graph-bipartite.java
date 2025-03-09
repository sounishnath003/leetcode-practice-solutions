public class Solution {
    // https://leetcode.com/problems/is-graph-bipartite/
    public boolean isBipartite(int[][] graph) {
        int nodes = graph.length;
        int[] colors = new int[nodes];
        Arrays.fill(colors, -1); // Uncolored node

        // Explore all the nodes and color it
        for (int node = 0; node < nodes; node++) {
            // Pick the uncolored node
            if (colors[node] == -1) {
                boolean isColorable = this.colorItWithBFS(graph, node, colors, 0);
                if (!isColorable)
                    return false;
            }
        }

        return true;
    }

    private boolean colorItWithDFS(int[][] graph, int node, int[] colors, int color) {
        // Apply the main conditional check
        // If the node is already color and it is same color
        // Simply return False
        if (colors[node] != -1) {
            return colors[node] == color;
        }

        // Color the node and update the colormap
        colors[node] = color;
        // Explore all neigh and try to color them with opposite color
        for (int neigh : graph[node]) {
            if (!this.colorItWithDFS(graph, neigh, colors, 1 - color)) {
                return false;
            }
        }

        return true;
    }

    private boolean colorItWithBFS(int[][] graph, int startNode, int[] colors, int color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        colors[startNode] = color;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neigh : graph[node]) {
                if (colors[neigh] == -1) {
                    // Color the neighbor with opposite color
                    colors[neigh] = 1 - colors[node];
                    queue.add(neigh);
                } else if (colors[neigh] == colors[node]) {
                    // If the neighbor is already colored with the same color, return false
                    return false;
                }
            }
        }

        return true;
    }
}
