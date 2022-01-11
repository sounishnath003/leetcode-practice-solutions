class Solution {
    private class Node {
        String value;
        List<String> adjacentNodes;

        public Node(String value, List<String> adjacentNodes) {
            this.value = value;
            this.adjacentNodes = adjacentNodes;
        }
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        /**
         * actually this problem is nothing but a dijsktra algorithm.
         * and dijsktra is nothing but a typical PQ + BFS
         *
         * so as JKF is the source node for all cases, we will find 1:m the shortest path
         * push adjacent dictionary order {node} by popping out from PQ.
         *
         * do this until PQ gets empty()
         */

        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticketInfo : tickets) {
            String fromNode = ticketInfo.get(0);
            String toNode = ticketInfo.get(1);

            graph.putIfAbsent(fromNode, new ArrayList<>());
            graph.get(fromNode).add(toNode);
        }
        System.out.println(graph);

        /**
         * Map{fromNode, PQ{}}
         */

        List<String> orderDestinations = new ArrayList<>();
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("JFK");

        while (!queue.isEmpty()) {
            String node = queue.poll();
            // for all neighbour from node
            orderDestinations.add(node);
            List<String> neighbours = graph.get(node);
            while (neighbours != null && !neighbours.isEmpty()){
                String popped = neighbours.remove(neighbours.size()-1);
                queue.add(popped);
            }
        }

        return orderDestinations;
    }
}
