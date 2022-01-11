class Solution {
    private class Node {
        int neighbour;
        int cost;

        public Node(int neighbour, int cost) {
            this.neighbour = neighbour;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "neighbour=" + neighbour +
                    ", cost=" + cost +
                    '}';
        }
    }
    private class NodeState {
        int nodevalue;
        int edgesPassed;
        int cost;

        public NodeState(int nodevalue, int edgesPassed, int cost) {
            this.nodevalue = nodevalue;
            this.edgesPassed = edgesPassed;
            this.cost = cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<Node>[] graph = getGraph(n, flights);
        // System.out.println(Arrays.toString(graph));

        PriorityQueue<NodeState> priorityQueue = new PriorityQueue<>((a, b) -> a.cost -  b.cost);
        priorityQueue.add(new NodeState(src, 0, 0));

        while (priorityQueue.isEmpty()==false) {
            NodeState node = priorityQueue.poll();
            if (node.nodevalue == dst) {
                return node.cost;
            }
            /**
             * why k+1?
             * because hop = 1 means 2 edges connecting 
             * 
             * A------>X----->Y------->B
             * if u see this graph, there exists 2 hops (X, Y).
             * but 3 edges connecting the path from A to B.
             * 
             * hence: hope = K, means edgePassed should be K+1
             */
            if (node.edgesPassed == k+1) {
                // means do not visited its adjacent nodes
                continue;
            }
            
            // explore all its neighbours and put it to pq
            for ( Node neighbourNode : graph[node.nodevalue] ) {
                int newCost = neighbourNode.cost + node.cost;
                int edgePassed = node.edgesPassed+1;
                int nodee = neighbourNode.neighbour;
                
                if (nodee == dst && edgePassed == k+1) return newCost;

                priorityQueue.add(new NodeState(nodee, edgePassed, newCost));
            }
        }
        return -1;
    }

    private List<Node>[] getGraph(int n, int[][] flights) {
        List<Node>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int c = flight[2];

            graph[u].add(new Node(v, c));
        }

        return graph;
    }
}
