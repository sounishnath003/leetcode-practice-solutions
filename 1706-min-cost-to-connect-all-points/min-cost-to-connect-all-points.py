class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        def prims_algorithm(edges: List[List[int]]) -> int:
            n = len(edges)
            min_cost = 0
            visited = set()
            pq = [(0,0)]

            while len(visited) < n:
                cost, i = heapq.heappop(pq)
                if i in visited: continue
                visited.add(i)
                min_cost += cost
                xi, yi = edges[i]

                for j in range(n):
                    if j in visited: continue
                    xj, yj = edges[j]
                    ncost = abs(xi-xj) + abs(yi-yj)
                    heapq.heappush(pq, (ncost, j))

            return min_cost

        return prims_algorithm(points)