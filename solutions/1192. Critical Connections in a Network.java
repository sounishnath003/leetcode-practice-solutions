class Solution {
    // Thankfully noe works !!
    private int time = 0;
​
    private void dfsArticulation(ArrayList<ArrayList<Integer>> graph, 
    int src, boolean[] vis, int[] parent, int[] disc, int[] low, boolean[] arti,
    List<List<Integer>> res) {
        disc[src] = low[src] = time;
        time++;
        vis[src] = true;
        int count = 0; // count for finding original source status about articulation
        for(int nbr : graph.get(src)) {
            if(vis[nbr] == true && parent[src] != nbr) {
                // visited but not parent
                low[src] = Math.min(low[src], disc[nbr]);
            } else if(vis[nbr] == false) {
                // unvisited neighbour
                parent[nbr] = src;
                dfsArticulation(graph, nbr, vis, parent, disc, low, arti, res);
                low[src] = Math.min(low[src], low[nbr]);
                count++; // increment in count if we are making call to nbr
                if(disc[src] < low[nbr]) {
                    List<Integer> edge = new ArrayList<>();
                    edge.add(src);
                    edge.add(nbr);
                    res.add(edge);
                    arti[src] = true;
                }
            }
        }
    }
​
​
    private List<List<Integer>> articulationBridge(ArrayList<ArrayList<Integer>> graph) {
        int count = 0;
        int n = graph.size();
        int[] parent = new int[n];
        int[] disc = new int[n];
        int[] low = new int[n];
        boolean[] vis = new boolean[n];
        boolean[] arti = new boolean[n];
        parent[0] = -1; // parent of starting point is -1
        time = 0;
