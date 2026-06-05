class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
            def build_graph():
                graph = defaultdict(list)
                for u,v,wt in edges:
                    graph[u].append((v,wt))
                    graph[v].append((u,wt))
                return graph

            graph = build_graph()
            # approach:
            # run dijsktra from every node / vertex and update the minimum reachable nodes
            # as we need to run SSSP for every node; better to use floyd-warshall as constraints as low
            # but i will stick to dijsktra only
            gmin = float("inf") # global reachable nodes with threshold <= whatever provided.
            ans = None

            def dijsktra(node:int):
                pq = [(0,node)] # cost,node
                dist = [math.inf] * n ; dist[node] = 0

                while pq:
                    cost,node = heapq.heappop(pq)
                    if cost > dist[node]: continue
                    for nei,ncost in graph[node]:
                        if cost + ncost < dist[nei]:
                            dist[nei] = cost + ncost
                            heapq.heappush(pq, (dist[nei], nei))
                return dist

            # O(n x ELogV x V)
            for node in range(n):
                dist = dijsktra(node)
                reachable = sum(1 \
                    for city,d in enumerate(dist) \
                    if city!=node and d <= distanceThreshold)
                
                if gmin >= reachable:
                    gmin = reachable
                    ans = node

            return ans