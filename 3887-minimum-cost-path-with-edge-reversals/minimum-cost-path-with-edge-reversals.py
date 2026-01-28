class Solution:
    def minCost(self, n: int, edges: List[List[int]]) -> int:
        def build_graph():
            graph = defaultdict(list)
            for u,v, wt in edges:
                graph[u].append((v, wt))
                graph[v].append((u, 2 * wt)) # based on the question:: trick only
            return graph

        graph = build_graph()

        dist = [float("inf")] * n
        dist[0] = 0
        pq = [(0,0)] # cost, node
        # shortest minimum cost -- dijsktra solution
        while pq:
            cost, node = heapq.heappop(pq)
            # optimization
            if cost > dist[node]:
                continue
            if node == n-1:
                return cost
            for nei, neicost in graph[node]:
                if dist[nei] > cost + neicost:
                    dist[nei] = cost + neicost
                    heapq.heappush(pq, (cost + neicost, nei))

        return -1