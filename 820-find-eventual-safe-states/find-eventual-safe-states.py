class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        N = len(graph)
        indegree = [0] * N
        def build_graph():
            g = defaultdict(list)
            for u in range(N):
                for v in graph[u]:
                    g[v].append(u)
                    indegree[u] += 1
            return g

        graph = build_graph()
        q = deque([node for node, d in enumerate(indegree) if d == 0])
        res = []

        while q:
            qs = len(q)
            for _ in range(qs):
                node = q.popleft()
                res.append(node)
                for nei in graph[node]:
                    indegree[nei] -= 1
                    if indegree[nei] == 0:
                        q.append(nei)

        return sorted(res)
        