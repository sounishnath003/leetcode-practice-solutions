class Solution:
    def longestCycle(self, edges: List[int]) -> int:
        n = len(edges)
        visited = {node: "NOT_VISITED" for node in range(n)}
        size_map = [1] * n
        gmax = -1

        def dfs_fn(node: int):
            nonlocal gmax
            if node == -1 or visited[node] == "VISITED":
                return False

            visited[node] = "VISITING"
            v = edges[node]
            if v != -1 and visited[v] == "NOT_VISITED":
                size_map[v] = size_map[node] + 1
                dfs_fn(v)
            elif v != -1 and visited[v] == "VISITING":
                gmax = max(gmax, size_map[node] - size_map[v] + 1)
            visited[node] = "VISITED"

            return False


        for node in range(n):
            if visited[node] == "NOT_VISITED":
                dfs_fn(node)

        return gmax
