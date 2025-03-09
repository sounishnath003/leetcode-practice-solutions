class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        nodes = len(graph)
        colors = [-1] * nodes  # -1 means uncolored

        for node in range(nodes):
            if colors[node] == -1:
                if not self.dfs(graph, node, colors, 0):
                    return False

        return True

    def dfs(self, graph, node, colors, color):
        if colors[node] != -1:
            return colors[node] == color  # Check if consistent with previous color

        colors[node] = color

        for neighbor in graph[node]:
            ctou = 1 if color == 0 else 0
            if not self.dfs(graph, neighbor, colors, ctou):
                return False

        return True