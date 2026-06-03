class Solution:
    def findCheapestPrice(self, n: int, flights: list[list[int]], src: int, dst: int, k: int) -> int:
        """
        1. Optimized: TC: O(V Log E) ; SC: O(N)
            1. Use the Dijsktra algorithm (BFS + PriorityQueue) and find the <= K stops
                1.1. Build the graph first -> u -> [(v,wt)]
            2. Until you hit the destination from the source.
            3. Return the minimum cost
        """

        graph = defaultdict(list)
        for u, v, wt in flights:
            graph[u].append((v, wt))

        # Min-heap: (cost_so_far, current_node, stops_so_far)
        pq = [(0, src, 0)]
        # visited[node][stops] = minimum cost to reach node with `stops` stops
        visited = dict()

        while pq:
            cost, node, stops = heapq.heappop(pq)
            if node == dst:
                return cost
            if stops > k:
                continue
            # If we've already been to node with fewer or same stops and cheaper, skip.
            if (node, stops) in visited and visited[(node, stops)] <= cost:
                continue
            visited[(node, stops)] = cost
            for neighbor, wt in graph[node]:
                heapq.heappush(pq, (cost + wt, neighbor, stops + 1))

        return -1
