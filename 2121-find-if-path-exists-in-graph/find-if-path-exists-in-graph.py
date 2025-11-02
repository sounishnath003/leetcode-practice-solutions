class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        """Solving using backtracking DFS"""
        
        def build_graph(edges: List[List[int]]) -> Dict[int, List[int]]:
            """helps to build a graph from the lists of edges"""
            graph = defaultdict(list)
            for u, v in edges:
                graph[u].append(v)
                graph[v].append(u)

            return graph

        graph = build_graph(edges)

        def dfs(node: int, visited: Set[int]) -> bool:
            """recursively go into their neighbours and check if we can reach the destination"""
            nonlocal graph
            if node == destination: return True
            visited.add(node)

            for neighbour in graph[node]:
                if neighbour not in visited and dfs(neighbour, visited): return True
            
            return False

        visited = set()
        return dfs(source, visited)


    def validPath2(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        class UnionFind:
            def __init__(self, nodes:int) -> None:
                self.nodes = int
                self.parents = list(range(nodes+1))
                self.rank = [1] * (self.nodes+1)

            def union(self, u:int, v:int) -> None:
                up = self.parents[u]
                vp = self.parents[v]
                if self.rank[up] < self.rank[vp]:
                    self.parents[up] = vp
                elif self.rank[up] > self.rank[vp]:
                    self.parents[vp] = up
                else:
                    self.parents[vp] = up
                    self.rank[up] += 1

            def find(self, u:int) -> int:
                if self.parents[u] != u:
                    self.parents[u] = self.find(self.parents[u])
                return self.parents[u]

            def are_connected(self, u:int, v:int) -> bool:
                return self.find(u) == self.find(v)


        uf = UnionFind(n)

        for u, v in edges:
            uf.union(u,v)

        return uf.are_connected(source, destination)