class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        Set<Integer> visitedSet = new HashSet<>();
​
        explorePaths(graph, 0, graph.length - 1, paths, currentPath, visitedSet);
        return paths;
    }
​
    private void explorePaths(int[][] graph, int currentNode, int dest, List<List<Integer>> paths,
            List<Integer> currentPath,
            Set<Integer> visitedSet) {
​
        currentPath.add(currentNode);
        visitedSet.add(currentNode);
​
        if (currentNode == dest) {
            paths.add(new ArrayList<>(currentPath));
            // return;
        }
​
        for (int neighbour : graph[currentNode]) {
            if (visitedSet.contains(neighbour))
                continue;
            explorePaths(graph, neighbour, dest, paths, currentPath, visitedSet);
        }
​
        visitedSet.remove(currentNode);
        currentPath.remove(currentPath.size() - 1);
    }
}
