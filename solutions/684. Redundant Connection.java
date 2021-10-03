class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        Arrays.fill(parent, -1);
​
        int[] ans = new int[2];
​
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
​
            if (parent[u] == -1) parent[u] = u;
            if (parent[v] == -1) parent[v] = v;
​
            int leader_u = find(parent, u);
            int leader_v = find(parent, v);
​
            if (leader_u != leader_v) {
                parent[leader_v] = leader_u;
            } else {
                ans = edge;
                break;
            }
        }
        return ans;
    }
​
    private int find(int[] parent, int f) {
        return (parent[f] == f) ? f : find(parent, parent[f]);
    }
}
