class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        N = len(graph)
        colors = [-1] * N

        # bipartite says -> NO adjacent nodes must have same color
        def dfs(node:int, color:int) -> bool:
            """returns True or False, True on bipartite"""
            colors[node] = color
            # explore all neighbours
            for neigh in graph[node]:
                if colors[neigh] == -1: # uncolor and unvisited
                    if not dfs(neigh, 1 - color): return False
                elif (colors[neigh] == color): return False

            return True

        for node in range(N):
            if colors[node] == -1:
                is_colorable = dfs(node, 0)
                if not is_colorable: return False

        return True