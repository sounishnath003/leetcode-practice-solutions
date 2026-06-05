
# 1976. Number of Ways to Arrive at Destination
# https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/


from collections import defaultdict
import heapq


class Solution:
    def countPaths(self, n: int, roads: list[list[int]]) -> int:
        """
        1. Optimized: TC: O(E Log V) ; SC: O(E + V)
            1. Use Dijsktra Algorithm and Count Paths: 
            2. Return the number of ways you can arrive at your destination in the shortest amount of time.Since the answer may be large, return it modulo 109 + 7.
            3. If the cost is < dist[nei]: count_paths[nei] = count_paths[node]
            4. If the cost is == dist[nei]: count_paths[nei] += count_paths[node]
        """

        def build_graph():
            graph = defaultdict(list)
            for u,v,wt in roads:
                graph[u].append((v, wt))
                graph[v].append((u, wt))
            return graph

        graph = build_graph()
        
        inf = float("inf")
        M = 10**9 + 7
        # count[i] = number of ways to reach node i
        count = [0] * n ; dist = [inf] * n ; 

        pq = [(0,0)] # (cost, node)
        dist[0] = 0;count[0] = 1 # if you are at 0 node, there is 1 way to go. by standing there.
        
        while pq:
            cost, node = heapq.heappop(pq)
            if cost > dist[node]:
                continue
            for nei, ncost in graph[node]:
                ncost += cost
                if dist[nei] > ncost:
                    dist[nei] = ncost
                    count[nei] = count[node]
                    heapq.heappush(pq, (ncost, nei))
                elif dist[nei] == ncost:
                    count[nei] = (count[nei] + count[node]) % M

        return count[n-1] % M