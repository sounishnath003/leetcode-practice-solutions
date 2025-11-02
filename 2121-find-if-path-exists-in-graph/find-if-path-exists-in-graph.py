class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        class UnionFind:
            def __init__(self, nodes:int) -> None:
                self.nodes = nodes
                self.parents = list(range(nodes+1))
                self.rank = [1] * (nodes+1)

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