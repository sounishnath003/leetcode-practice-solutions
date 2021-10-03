class Solution {
    public int find(int[] parent, int x) {
        if(parent[x] == x) {
            return x;
        }
​
        int temp = find(parent, parent[x]);
        parent[x] = temp;
        return temp;
    }
​
    public void union(int lx, int ly, int[] rank, int[] parent) {
        if(rank[lx] > rank[ly]) {
            parent[ly] = lx;
        } else if(rank[lx] < rank[ly]) {
            parent[lx] = ly;
        } else {
            parent[ly] = lx;
            rank[lx]++;
        }
    }
    // leetcode 1584. https://leetcode.com/problems/min-cost-to-connect-all-points/
    public int minCostConnectPoints(int[][] coords) {
        int size = coords.length * (coords.length - 1) / 2;
        int[][] points = new int[size][3];
​
        int indx = 0;
        for(int i = 0; i < coords.length; i++) {
            for(int j = i + 1; j < coords.length; j++) {
                int dist = Math.abs(coords[j][0] - coords[i][0]) + Math.abs(coords[j][1] - coords[i][1]);
                int[] point = {i, j, dist};
                points[indx] = point;
                indx++;
            }
        }
        
        // kruskal Algo, sort all the edges 
        Arrays.sort(points, (val1, val2) -> Integer.compare(val1[2], val2[2]));
​
        int[] parent = new int[coords.length];
        int[] rank = new int[coords.length];
​
        for(int i = 0; i < coords.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        int cost = 0;
        for(int i = 0; i < size; i++) {
            int u = points[i][0];
            int v = points[i][1];
            int wt = points[i][2];
​
            int lu = find(parent, u);
            int lv = find(parent, v);
​
            if(lu == lv)
                continue;
            
            union(lu, lv, rank, parent);
            // add edge
            cost += wt;
        }
        return cost;
    }
}
