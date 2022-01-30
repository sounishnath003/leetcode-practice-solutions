import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
​
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
​
        if (n <= 0) {
            return result;
        }
​
        if (n == 1) {
            result.add(0);
            return result;
        }
​
        int[] degrees = new int[n];
        Map<Integer, List<Integer>> adjacentLists = new HashMap<>();
​
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
​
            degrees[u] += 1;
            degrees[v] += 1;
​
            adjacentLists.putIfAbsent(u, new ArrayList<>());
            adjacentLists.putIfAbsent(v, new ArrayList<>());
​
            adjacentLists.get(u).add(v);
            adjacentLists.get(v).add(u);
        }
​
        Queue<Integer> queue = new LinkedList<>();
​
        for (int node = 0; node < degrees.length; node++) {
            if (degrees[node] == 1) {
                queue.add(node);
            }
        }
​
        while (n > 2) {
            int size = queue.size();
            n -= size;
​
            while (size > 0) {
                int u = queue.poll();
                for (int v : adjacentLists.get(u)) {
                    degrees[v] -= 1;
​
                    if (degrees[v] == 1) {
                        queue.add(v);
                    }
​
                }
​
                size--;
            }
        }
​
        return new ArrayList<>(queue);
    }
}
