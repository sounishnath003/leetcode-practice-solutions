
public class Solution {
    // https://leetcode.com/problems/course-schedule/
    // https://leetcode.com/problems/course-schedule-ii/
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return new SolutionUsingDFS().canFinish(numCourses, prerequisites);
    }

    private static class SolutionUsingBFS {
        /*
         * kahn algorithm
         * 
         * find the cycle in DAG using BFS -> in-degree of the verticies
         * using BFS (queue)
         */

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // prepare the adjacent list graph
            List<Integer>[] graph = new List[numCourses];

            for (int i = 0; i < numCourses; i++)
                graph[i] = new ArrayList<>();

            for (int[] edge : prerequisites) {
                // a ---> b
                int a = edge[0];
                int b = edge[1];

                graph[a].add(b);
            }

            int[] inDegree = new int[numCourses];

            // fill the in degrees of the verticis
            for (int u = 0; u < numCourses; u++) {
                for (int v : graph[u]) {
                    inDegree[v]++;
                }
            }

            // store the visited
            boolean[] visited = new boolean[numCourses];
            // store q
            Queue<Integer> queue = new LinkedList<>();
            // check the indegree === 0 and add them in Q
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                    visited[i] = true;
                }
            }

            // process the task from q
            // until its empty
            while (!queue.isEmpty()) {
                int u = queue.poll();

                // for all neightbous
                for (int v : graph[u]) {
                    inDegree[v]--;

                    if (inDegree[v] == 0 && visited[v] == false) {
                        // add them into Q
                        queue.add(v);
                        visited[v] = true;
                    }
                }
            }

            // check if its done
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] > 0)
                    return false;
            }

            return true;
        }
    }

    private static class SolutionUsingDFS {
        private enum NodeStatus {
            NOT_VISITED, IN_PROGRESS, VISITED
        };

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
                    if (!result)
                        return false;
                }
            }

            return true;
        }

        private boolean exploreTheGraph(List<Integer>[] graph, int source, NodeStatus[] visited) {
            if (visited[source] == NodeStatus.VISITED)
                return true;
            if (visited[source] == NodeStatus.IN_PROGRESS)
                return false;

            visited[source] = NodeStatus.IN_PROGRESS;
            // explore all adj nodes of the source
            for (int v : graph[source]) {
                boolean rres = exploreTheGraph(graph, v, visited);
                if (!rres)
                    return false;
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
}
