import heapq
from collections import defaultdict
from typing import List

class Solution:
    def minimumCost(
        self,
        source: str,
        target: str,
        original: List[str],
        changed: List[str],
        cost: List[int]
    ) -> int:
        
        graph = defaultdict(list)
        for o, c, w in zip(original, changed, cost):
            graph[o].append((c, w))
        
        def dijkstra(start: str):
            dist = {chr(ord('a') + i): float('inf') for i in range(26)}
            dist[start] = 0
            pq = [(0, start)]
            
            while pq:
                cur_dist, u = heapq.heappop(pq)
                if cur_dist > dist[u]:
                    continue
                for v, w in graph[u]:
                    nd = cur_dist + w
                    if nd < dist[v]:
                        dist[v] = nd
                        heapq.heappush(pq, (nd, v))
            return dist
        
        memo = {}
        total_cost = 0
        
        for s, t in zip(source, target):
            if s == t:
                continue
            if s not in memo:
                memo[s] = dijkstra(s)
            if memo[s][t] == float('inf'):
                return -1
            total_cost += memo[s][t]
        
        return total_cost
