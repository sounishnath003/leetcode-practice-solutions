class Solution:
    def restoreArray(self, adjacentPairs: List[List[int]]) -> List[int]:
        def build_graph():
            graph = defaultdict(list)
            for (u,v) in adjacentPairs:
                graph[u].append(v)
                graph[v].append(u)
            return graph

        graph = build_graph()
        result = []

        start_node = [ node for node in graph if len(graph[node]) == 1 ]

        # cannot process data
        if not start_node:
            return result

        visited = set()

        def dfs(node):
            visited.add(node)
            for nei in graph[node]:
                if not nei in visited:
                    dfs(nei)
            result.append(node)

        dfs(start_node[-1])

        return result