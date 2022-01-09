class Solution {
    private enum NodeStatus {UNTOUCHED, IN_PROGRESS, COMPLETED};

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List[] graph = getGraph(numCourses, prerequisites);
        // System.out.println(Arrays.toString(graph));

        /**
         * if cycle in DAG return empty[],
         * because pre-req cannot be completed
         *
         * it is impossible to finish all courses, return an empty array.
         */

        NodeStatus[] tracking = new NodeStatus[numCourses];
        Arrays.fill(tracking, NodeStatus.UNTOUCHED);

        for (int node = 0; node < graph.length; node++) {
            if (isCompletlyDiscovered(tracking[node], NodeStatus.UNTOUCHED)) {
                if (isCyclic(graph, node, tracking)){
                    return new int[]{};
                }
            }
        }

        /**
         * find the dependency array
         * by finding the topological ordering of nodes
         */

        Stack<Integer> topologicalOrdering = new Stack<>();
        boolean[] visited = new boolean[numCourses];
        for (int node = 0; node < graph.length; node++) {
            if (visited[node]==false) {
                findTopologicalOrder(graph, node, visited, topologicalOrdering);
            }
        }
        
        int[] answer = new int[topologicalOrdering.size()];
        
        int index = 0;
        while (topologicalOrdering.isEmpty()==false) {
            int v = topologicalOrdering.pop();
            answer[index] = v;
            index++;
        }
        
        return answer;
    }

    private void findTopologicalOrder(List<Integer>[] graph, int node, boolean[] visited, Stack<Integer> topologicalOrdering) {
        visited[node] = true;
        for (int v : graph[node]) {
            if (!visited[v]) {
                findTopologicalOrder(graph, v, visited, topologicalOrdering);
            }
        }
        topologicalOrdering.add(node);
    }

    private boolean isCyclic(List<Integer>[] graph, int node, NodeStatus[] tracking) {
        if (isCompletlyDiscovered(tracking[node], NodeStatus.COMPLETED)) return false;
        if(isInProgress(tracking[node], NodeStatus.IN_PROGRESS)) return true;

        tracking[node] = NodeStatus.IN_PROGRESS;
        for (int adjNode : graph[node]) {
            boolean rres = isCyclic(graph, adjNode, tracking);
            if (rres) return true;
        }
        tracking[node] = NodeStatus.COMPLETED;
        return false;
    }

    private boolean isInProgress(NodeStatus nodeStatus, NodeStatus inProgress) {
        return nodeStatus == inProgress;
    }

    private boolean isCompletlyDiscovered(NodeStatus nodeStatus, NodeStatus completed) {
        return nodeStatus == completed;
    }

    private List[] getGraph(int numCourses, int[][] prerequisites) {
        List[] graph = new List[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int[] nodes : prerequisites) {
            int firstNode = nodes[0];
            int secondNode = nodes[1];

            // second --> first
            graph[secondNode].add(firstNode);
        }
        return graph;
    }
}
