class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        def build_graph(times: List[List[int]]) -> Dict[int, List[int]]:
            """builds the graph and return adjacency dictionary"""
            graph = defaultdict(list)
            for u, v, w in times: graph[u].append((v,w))
            return graph

        graph = build_graph(times)
        min_times = {}
        pq = [(0, k)] # cost, dist

        while pq:
            dcost, node = heapq.heappop(pq)
            if node in min_times: continue

            min_times[node] = dcost
            for neighbor, cost in graph[node]:
                if neighbor not in min_times or dcost + cost < min_times[node]:
                    heapq.heappush(pq, (cost+dcost, neighbor))

        return max(min_times.values()) if len(min_times) == n else -1