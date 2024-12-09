class Solution {
​
    private static class Node implements Comparable<Node> {↔}
​
    public int findCheapestPrice(int totalFlights, int[][] flights, int src, int dst, int k) {
        // TC: O(E log V * # flights) where E is the number of edges and V is the number
        // of
        // vertices.
        // SC: O(V) because of distance map and visited map.
​
        /**
         * There are n cities and m edges connected by some number of flights. You are
         * given an array of flights where flights[i] = [ fromi, toi, pricei] indicates
         * that there is a flight from city fromi to city toi with cost price. You have
         * also given three integers src, dst, and k, and return the cheapest price from
         * src to dst with at most k stops. If there is no such route, return -1.
         */
​
        List<Node>[] graph = new List[totalFlights];
​
        for (int i = 0; i < totalFlights; i++) {
            graph[i] = new ArrayList<>();
        }
​
        // build the graph
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
​
            graph[u].add(new Node(0, v, w));
        }
​
        // declare the linked list.
        Queue<Node> pq = new LinkedList<>();
        // declare the visited list
        boolean[] visitedMap = new boolean[totalFlights];
        int[] distanceMap = new int[totalFlights];
​
        // fill the distanceMap with 1e9
        Arrays.fill(distanceMap, Integer.MAX_VALUE);
​
        // add the src into pq
        pq.offer(new Node(0, src, 0));
​
        // perform dijsktra using Queue
        while (pq.isEmpty() == false) {
            Node node = pq.poll();
            // System.out.println("visit:\t" + node);
            if (node.steps > k)
